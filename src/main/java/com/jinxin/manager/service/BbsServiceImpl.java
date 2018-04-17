package com.jinxin.manager.service;

import com.jinxin.manager.dao.customer.BbsMsgDao;
import com.jinxin.manager.po.BbsMsg;
import com.jinxin.manager.util.ConvertUtils;
import com.jinxin.manager.vo.BbsMsgVo;
import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yezhangyuan on 2018-04-17.
 *
 * @author yezhangyuan
 */
@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	private BbsMsgDao bbsMsgDao;

	@Override
	public PageInfo<List<BbsMsgVo>> listBbsContent(RequestPage page) {
		PageInfo<List<BbsMsgVo>> pageInfo = new PageInfo<>();
		int total = bbsMsgDao.queryTotalBbs();
		List<BbsMsg> bbsMsgs = bbsMsgDao.queryPageBbsContent(page.getStart(), page.getRows());
		if (CollectionUtils.isNotEmpty(bbsMsgs)) {
			List<BbsMsgVo> bbsMsgVos = ConvertUtils.copyPropertiesList(BbsMsgVo.class, bbsMsgs);
			pageInfo.setRows(bbsMsgVos);
		}
		pageInfo.setTotal(total);
		return pageInfo;
	}


}
