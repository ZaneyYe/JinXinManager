package com.jinxin.manager.controller;

import com.jinxin.manager.enumkit.Constants;
import com.jinxin.manager.enumkit.StateInfo;
import com.jinxin.manager.service.PicService;
import com.jinxin.manager.vo.ImgInfoVo;
import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;
import com.jinxin.manager.vo.ResponseEntity;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yzy on 2017/08/10 下午 2:43.
 * email: mia5121@163.com
 * 图片接口
 */
@RequestMapping("/pic")
@Controller
public class PicController extends BaseController {

	@Autowired
	private PicService picService;

	/**
	 * 图片列表
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list.do")
	@ResponseBody
	public PageInfo<List<ImgInfoVo>> listPics(HttpServletRequest request, RequestPage page) {
		LOGGER.info("pic list loading, {}, {} ....", page.getPage(), page.getRows());
		PageInfo<List<ImgInfoVo>> pageInfo = picService.queryAllPics(page);
		return pageInfo;
	}


	/**
	 * 上传图片
	 *
	 * @param request
	 * @param desc
	 * @param file
	 */
	@RequestMapping(value = "/uploadPic.do", method = RequestMethod.POST)
	public void uploadPic(HttpServletRequest request,
						  @RequestParam("desc") String desc,
						  @RequestParam("upFile") MultipartFile file) {
		LOGGER.info("pic uploading, {}, {}....", desc, file.getOriginalFilename());

		if (!file.isEmpty()) {
			//上传文件
			//文件名
			String fileName = file.getOriginalFilename();
			//目的文件
			String descPath = Constants.localUploadPath + fileName;
			try {
				FileCopyUtils.copy(file.getBytes(), new File(descPath));
			} catch (IOException e) {
				e.printStackTrace();
				LOGGER.error("上传失败,{}::", file.getOriginalFilename());
				return;
			}
			//上传成功后，保存pic信息
			String upShowPath = Constants.localShowPath + fileName;
			picService.addPic(desc, upShowPath);
		}
		return;
	}


	@RequestMapping(value = "/delPic.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<StateInfo> delPic(HttpServletRequest request, Integer picId) {
		ResponseEntity<StateInfo> entity = new ResponseEntity<>();
		LOGGER.info("picId....{}", picId);
		picService.delPic(picId);
		entity.setResult(StateInfo.SUCCESS);
		return entity;
	}


	@RequestMapping(value = "ue/uploadPic.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> images(MultipartFile upfile, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			String basePath = Constants.localUploadPath;
			String visitUrl = Constants.localShowPath;
			if (basePath == null || "".equals(basePath)) {
				basePath = "E:\\JinXin\\pics\\";  //与properties文件中lyz.uploading.url相同，未读取到文件数据时为basePath赋默认值
			}
			if (visitUrl == null || "".equals(visitUrl)) {
				visitUrl = "http://localhost/"; //与properties文件中lyz.visit.url相同，未读取到文件数据时为visitUrl赋默认值
			}
			String fileName = String.valueOf(System.currentTimeMillis()).concat("_")
					.concat(String.valueOf(RandomUtils.nextInt())).concat(".")
					.concat(upfile.getOriginalFilename());
			StringBuilder sb = new StringBuilder();
			//拼接保存路径
			sb.append(basePath).append("/").append(fileName);
			visitUrl = visitUrl.concat(fileName);
			File f = new File(sb.toString());
			if (!f.exists()) {
				f.getParentFile().mkdirs();
			}
			OutputStream out = new FileOutputStream(f);
			FileCopyUtils.copy(upfile.getInputStream(), out);
			params.put("state", "SUCCESS");
			params.put("url", visitUrl);
			params.put("size", upfile.getSize());
			params.put("original", fileName);
			params.put("type", upfile.getContentType());
		} catch (Exception e) {
			params.put("state", "ERROR");
		}
		return params;
	}


}
