package com.jinxin.manager.controller;

import com.jinxin.manager.enumkit.Constants;
import com.jinxin.manager.enumkit.StateInfo;
import com.jinxin.manager.service.PicService;
import com.jinxin.manager.vo.ImgInfoVo;
import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;
import com.jinxin.manager.vo.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by yzy on 2017/08/10 下午 2:43.
 * email: mia5121@163.com
 * 图片接口
 */
@RequestMapping("/pic")
@Controller
public class PicController extends BaseController{

	@Autowired
	private PicService picService;

	/**
	 * 图片列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list.do")
	@ResponseBody
	public PageInfo<List<ImgInfoVo>> listPics(HttpServletRequest request, RequestPage page){
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
	@ResponseBody
	public ResponseEntity<StateInfo> uploadPic(HttpServletRequest request,
											   @RequestParam("desc") String desc,
											   @RequestParam("upFile") MultipartFile file) {
		LOGGER.info("pic uploading, {}, {}....", desc, file.getOriginalFilename());
		ResponseEntity<StateInfo> entity = new ResponseEntity<>();
		if (!file.isEmpty()) {
			//上传文件
			String fileName = file.getOriginalFilename(); //文件名
			String contextPath = request.getContextPath();
			LOGGER.info("contextPath:: {}", contextPath);
			String descPath = Constants.localUploadPath + fileName; //目的文件
			try {
				FileCopyUtils.copy(file.getBytes(), new File(descPath));
			} catch (IOException e) {
				e.printStackTrace();
				entity.setResult(StateInfo.FAILED);
				LOGGER.error("上传失败,{}::", file.getOriginalFilename());
				return entity;
			}

			//上传成功后，保存pic信息
			String upShowPath = Constants.localShowPath + fileName;

			picService.addPic(desc, upShowPath);
			entity.setResult(StateInfo.SUCCESS);
		}
		entity.setResult(StateInfo.FAILED);
		return entity;
	}


}
