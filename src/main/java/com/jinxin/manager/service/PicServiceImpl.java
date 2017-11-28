package com.jinxin.manager.service;

import com.jinxin.manager.dao.PicDao;
import com.jinxin.manager.po.ImgInfo;
import com.jinxin.manager.vo.BussinessException;
import com.jinxin.manager.vo.ImgInfoVo;
import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public PageInfo<List<ImgInfoVo>> queryAllPics(RequestPage page) {
		PageInfo<List<ImgInfoVo>> result = new PageInfo<>();
		Integer total = picDao.countTotalPics();
		long start = page.getStart();
		long limit = page.getRows();
		List<ImgInfo> imgInfoList = picDao.queryAllPics(start, limit);
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
	@Transactional(rollbackFor = {})
	public void addPic(String desc, String descPath) {
		if (StringUtils.isBlank(desc)) {
			throw new BussinessException("图片描述不能为空");
		}
		ImgInfo imgInfo = new ImgInfo();
		imgInfo.setType(2);
		imgInfo.setRemark(desc);
		imgInfo.setUrl(descPath);
		imgInfo.setCreatetime(new Date());
		imgInfo.setUpdatetime(new Date());
		picDao.insertSelective(imgInfo);
		LOGGER.info("保存图片成功,{}...", descPath);
	}

	@Override
	public void delPic(Integer picId) {
		if (null == picId) {
			throw new BussinessException("删除图片,图片id为空");
		}
		ImgInfo imgInfo = new ImgInfo();
		imgInfo.setId(picId);
		imgInfo.setIsDel(false); //1 为有效，0 为删除
		picDao.updateByPrimaryKeySelective(imgInfo);
		LOGGER.info("删除图片成功,id::{}...", picId);
	}


}
