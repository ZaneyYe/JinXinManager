package com.jinxin.manager.dao.customer;

import com.jinxin.manager.dao.base.BbsMsgMapper;
import com.jinxin.manager.po.BbsMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yezhangyuan on 2018-04-17.
 *
 * @author yezhangyuan
 */
public interface BbsMsgDao extends BbsMsgMapper {
	/**
	 * 统计所有留言数量
	 *
	 * @return
	 */
	int queryTotalBbs();

	/**
	 * 分页查询留言
	 *
	 * @param start
	 * @param rows
	 * @return
	 */
	List<BbsMsg> queryPageBbsContent(@Param("start") Integer start, @Param("rows") Integer rows);

}
