package com.jinxin.manager.service;

import com.jinxin.manager.dao.PicDao;
import com.jinxin.manager.po.ImgInfo;
import com.jinxin.manager.vo.BussinessException;
import com.jinxin.manager.vo.ImgInfoVo;
import com.jinxin.manager.vo.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yzy on 2017/08/10 下午 3:04.
 * email: mia5121@163.com
 */
@Service
public class PicServiceImpl implements PicService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PicServiceImpl.class);

	@Autowired
	private PicDao picDao;

	@Override
	public PageInfo<List<ImgInfoVo>> queryAllPics() {
//		List<ImgInfoVo> imgInfos = new ArrayList<>();
//		ImgInfoVo img1 = new ImgInfoVo();
//		ImgInfoVo img2 = new ImgInfoVo();
//		img1.setId(1);
//		img1.setType(1);
//		img1.setUrl("http://xxx.xxx");
//		img1.setCreatetime(new Date());
//		img2.setId(2);
//		img2.setType(2);
//		img2.setUrl("http://yyy.yyy");
//		img2.setCreatetime(new Date());
//		imgInfos.add(img1);
//		imgInfos.add(img2);
//		PageInfo<List<ImgInfoVo>> result = new PageInfo<>();
//		result.setTotal(2);
//		result.setRows(imgInfos);

		PageInfo<List<ImgInfoVo>> result = new PageInfo<>();
		Integer total = picDao.countTotalPics();
		List<ImgInfo> imgInfoList = picDao.queryAllPics();
		List<ImgInfoVo> imgInfoVos = new ArrayList<>();
		for(ImgInfo imgInfo : imgInfoList){
			ImgInfoVo imgInfoVo = new ImgInfoVo(imgInfo);
			imgInfoVos.add(imgInfoVo);
		}
		result.setTotal(total);
		result.setRows(imgInfoVos);
		return result;
	}


	@Override
	public void addPic(String desc, String descPath) {
		if (StringUtils.isBlank(desc)) {
			throw new BussinessException("图片描述不能为空");
		}
		ImgInfo imgInfo = new ImgInfo();
		imgInfo.setType(2);
		imgInfo.setRemark(desc);
		imgInfo.setUrl(descPath);
		imgInfo.setCreatetime(new Date());
		picDao.insertSelective(imgInfo);
		LOGGER.info("保存图片成功,{}...", descPath);
	}


}
