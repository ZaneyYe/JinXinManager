package com.jinxin.manager.service;

import com.jinxin.manager.dao.customer.BbsMsgDao;
import com.jinxin.manager.po.BbsMsg;
import com.jinxin.manager.util.ConvertUtils;
import com.jinxin.manager.vo.BbsMsgVo;
import com.jinxin.manager.vo.BussinessException;
import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yezhangyuan on 2018-04-17.
 *
 * @author yezhangyuan
 */
@Service
public class BbsServiceImpl implements BbsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BbsServiceImpl.class);

	@Autowired
	private BbsMsgDao bbsMsgDao;

	@Override
	public PageInfo<List<BbsMsgVo>> listBbsContent(RequestPage page) {
		PageInfo<List<BbsMsgVo>> pageInfo = new PageInfo<>();
		int total = bbsMsgDao.queryTotalBbs();
		List<BbsMsg> bbsMsgs = bbsMsgDao.queryPageBbsContent(page.getStart(), page.getRows());
		List<BbsMsgVo> bbsMsgVos = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(bbsMsgs)) {
			bbsMsgVos = ConvertUtils.copyPropertiesList(BbsMsgVo.class, bbsMsgs);
		}
		pageInfo.setRows(bbsMsgVos);
		pageInfo.setTotal(total);
		return pageInfo;
	}

	@Override
	public void delBbsContent(String bbsId) {
		if (StringUtils.isBlank(bbsId)) {
			LOGGER.warn("传参为空");
			return;
		}
		BbsMsg bbsMsg = bbsMsgDao.selectByPrimaryKey(Integer.parseInt(bbsId));
		if (bbsMsg == null) {
			throw new BussinessException("评论不存在");
		}
		try {
			bbsMsgDao.deleteByPrimaryKey(Integer.parseInt(bbsId));
		} catch (Exception ex) {
			LOGGER.error("评论删除失败", ex);
			throw new BussinessException("该评论删除失败");
		}
	}




}
