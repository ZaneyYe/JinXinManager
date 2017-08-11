package com.jinxin.manager.vo;

import com.jinxin.manager.po.ImgInfo;
import com.jinxin.manager.util.DateFormatUtil;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by yzy on 2017/08/11 上午 11:10.
 * email: mia5121@163.com
 */
public class ImgInfoVo extends ImgInfo {

	public ImgInfoVo() {
	}

	public ImgInfoVo(ImgInfo imgInfo) {
		try {
			BeanUtils.copyProperties(this, imgInfo);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public String getCreateTimeStr(){
		if(getCreatetime() == null){
			return "";
		}
		return DateFormatUtil.dateToString(getCreatetime());
	}


}
