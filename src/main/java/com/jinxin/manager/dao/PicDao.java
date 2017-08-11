package com.jinxin.manager.dao;

import com.jinxin.manager.dao.base.ImgInfoMapper;
import com.jinxin.manager.po.ImgInfo;

import java.util.List;

/**
 * Created by yzy on 2017/08/10 下午 3:17.
 * email: mia5121@163.com
 */
public interface PicDao extends ImgInfoMapper {

	List<ImgInfo> queryAllPics();

	Integer countTotalPics();

}
