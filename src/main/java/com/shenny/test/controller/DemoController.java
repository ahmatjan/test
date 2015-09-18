package com.shenny.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: DemoController
 * @Description:
 * @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>
 * @date 2015年9月16日 上午11:10:57
 */

@Controller
public class DemoController {

	@RequestMapping("index1")
	public String index() {
		
		return "index";
	}
}
