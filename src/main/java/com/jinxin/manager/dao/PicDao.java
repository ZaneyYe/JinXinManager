package com.jinxin.manager.dao;

import com.jinxin.manager.dao.base.ImgInfoMapper;
import com.jinxin.manager.po.ImgInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yzy on 2017/08/10 下午 3:17.
 * email: mia5121@163.com
 */
public interface PicDao extends ImgInfoMapper {

	List<ImgInfo> queryAllPics(@Param("start") long start, @Param("limit") long limit);

	Integer countTotalPics();

}
