package com.jinxin.manager.service;

import com.jinxin.manager.po.ImgInfo;
import com.jinxin.manager.vo.PageInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzy on 2017/08/10 下午 3:04.
 * email: mia5121@163.com
 */
@Service
public class PicServiceImpl implements PicService {

//	@Autowired
//	private PicDao picDao;

	@Override
	public PageInfo<ImgInfo> queryAllPics() {
		List<ImgInfo> imgInfos = new ArrayList<>();
		ImgInfo img1 = new ImgInfo();
		ImgInfo img2 = new ImgInfo();
		img1.setId(1);
		img1.setType(1);
		img1.setUrl("http://xxx.xxx");
		img2.setId(2);
		img2.setType(2);
		img2.setUrl("http://yyy.yyy");
		imgInfos.add(img1);
		imgInfos.add(img2);
		PageInfo<ImgInfo> result = new PageInfo<>();
		result.setTotal(2);
		result.setRows(imgInfos);
		return result;
	}


}
