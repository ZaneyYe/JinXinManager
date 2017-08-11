package com.jinxin.manager.service;

import com.jinxin.manager.vo.ImgInfoVo;
import com.jinxin.manager.vo.PageInfo;

import java.util.List;

/**
 * Created by yzy on 2017/08/10 下午 3:02.
 * email: mia5121@163.com
 */
public interface PicService {

	/**
	 *
	 * @return
	 */
	PageInfo<List<ImgInfoVo>> queryAllPics();
}
