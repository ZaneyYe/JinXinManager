package com.jinxin.manager.interceptor;

import com.jinxin.manager.enumkit.StateInfo;
import com.jinxin.manager.vo.BussinessException;
import com.jinxin.manager.vo.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yzy on 2017/7/23.
 * email: mia5121@163.com
 * 异常拦截处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger LOGGER = LoggerFactory.getLogger(getClass());

	@ExceptionHandler
	@ResponseBody
	public ResponseEntity<Void> handler(Exception ex){
		ResponseEntity<Void> entity = new ResponseEntity<>();
		if(ex instanceof BussinessException){
			//业务性异常
			entity.setCode(((BussinessException) ex).getErrorCode());
			entity.setMessage(ex.getMessage());
		}else{
			entity.setCode(StateInfo.FAILED.getCode());
			entity.setMessage(StateInfo.FAILED.getMessage());
		}
		return entity;
	}
}
