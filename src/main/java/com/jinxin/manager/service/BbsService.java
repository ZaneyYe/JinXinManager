package com.jinxin.manager.service;

import com.jinxin.manager.vo.BbsMsgVo;
import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;

import java.util.List;

/**
 * Created by yezhangyuan on 2018-04-17.
 *
 * @author yezhangyuan
 * @describe 留言板接口
 */
public interface BbsService {
	/**
	 * 留言列表查詢接口
	 *
	 * @param page
	 * @return
	 */
	PageInfo<List<BbsMsgVo>> listBbsContent(RequestPage page);

}
