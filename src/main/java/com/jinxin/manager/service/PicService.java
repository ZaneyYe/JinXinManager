package com.jinxin.manager.service;

import com.jinxin.manager.vo.ImgInfoVo;
import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;

import java.util.List;

/**
 * Created by yzy on 2017/08/10 下午 3:02.
 * email: mia5121@163.com
 */
public interface PicService {

	/**
	 * 查询所有的图片
	 * @return
	 */
	PageInfo<List<ImgInfoVo>> queryAllPics(RequestPage page);

	/**
	 * 增加图片
	 *
	 * @param desc
	 * @param descPath
	 */
	void addPic(String desc, String descPath);

}
