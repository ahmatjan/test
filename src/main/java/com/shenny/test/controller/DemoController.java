package com.shenny.test.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shenny.test.dao.IEcSaleImgDao;
import com.shenny.test.model.EcSaleImg;

/**
 * @ClassName: DemoController
 * @Description:
 * @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>
 * @date 2015年9月16日 上午11:10:57
 */

@Controller
public class DemoController {
	
	@Inject
	IEcSaleImgDao ecSaleImgDao;

	@RequestMapping("index")
	public String index() {
		
		List<EcSaleImg> list = ecSaleImgDao.listAllImg();
		for (EcSaleImg img : list) {
			System.out.println(img.getId() + "\t" + img.getSaleId() + "\t" + img.getImgUri());
		}
		return "index";
	}
}
