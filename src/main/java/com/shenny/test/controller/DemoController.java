package com.shenny.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.shenny.test.alipay.AlipaySubmit;
import com.shenny.test.dao.IEcSaleImgDao;
import com.shenny.test.model.ResultObj;
import com.shenny.test.service.ILuceneService;
import com.shenny.test.service.IUserService;
import com.shenny.test.util.AlipayConfig;
import com.shenny.test.util.JsoupUtil;

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

	@Inject
	IUserService userService;

	@Inject
	ILuceneService luceneService;

	@RequestMapping("index")
	// @User
	public String index(Model model, @RequestParam(value = "v", required = false) final Integer v,
			@RequestParam(value = "date", required = false) final String date) {
		if (StringUtils.isNotBlank(date) && date.length() != 8)
			return "index2";
		try {
			model.addAttribute("hotKeyword",
					JsoupUtil.getJson("http://news.baidu.com/n?m=rddata&v=hot_word&type=0&date="
							+ (StringUtils.isBlank(date) ? "" : date)));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("date", date);
		model.addAttribute("news", JsoupUtil.getWebPage("http://news.baidu.com/"));
		if (v != null && v.intValue() == 2)
			return "index2";
		return "index";
	}

	@RequestMapping("redis")
	@ResponseBody
	public String redisTest() {
		return String.valueOf(userService.addData());
	}

	@RequestMapping("mysql")
	@ResponseBody
	public String mysqlTest() {
		ecSaleImgDao.insert("1");
		return "1";
	}

	@RequestMapping(value = "error", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String error() {

		ResultObj res = new ResultObj();
		res.setErrorCode(500);
		res.setErrorMsg("未授权");
		// System.out.println("error");
		userService.syncTest();
		return JSON.toJSONString(res);
	}

	@RequestMapping("lucene")
	@ResponseBody
	public String lucene() {
		return JSON.toJSONString(luceneService.query("整型美容"));
	}

	@RequestMapping("buy")
	@ResponseBody
	public String buy() {
		return JSON.toJSONString(userService.buy());
	}

	@RequestMapping("alipay")
	public String alipay() {
		return "alipay";
	}

	@RequestMapping("pay")
	public String turnToAlipay(Model model, @RequestParam("WIDout_trade_no") String out_trade_no,
			@RequestParam("WIDsubject") String subject, @RequestParam("WIDtotal_fee") String total_fee,
			@RequestParam("WIDshow_url") String show_url) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("out_trade_no", out_trade_no);
		params.put("subject", subject);
		params.put("total_fee", total_fee);
		params.put("show_url", show_url);
		params.put("service", "alipay.wap.create.direct.pay.by.user");
		params.put("partner", AlipayConfig.partner);
		params.put("seller_id", AlipayConfig.seller_id);
		params.put("_input_charset", AlipayConfig.input_charset);
		String payment_type = "1";
		//必填，不能修改
		//服务器异步通知页面路径
		String notify_url = "http://商户网关地址/alipay.wap.create.direct.pay.by.user-JAVA-UTF-8/notify_url.jsp";
		//需http://格式的完整路径，不能加?id=123这类自定义参数

		//页面跳转同步通知页面路径
		String return_url = "http://商户网关地址/alipay.wap.create.direct.pay.by.user-JAVA-UTF-8/return_url.jsp";
		params.put("payment_type", payment_type);
		params.put("notify_url", notify_url);
		params.put("return_url", return_url);
		params = AlipaySubmit.buildRequestPara(params);
		for(String key:params.keySet()){
			model.addAttribute(key, params.get(key));
		}
		return "redirect:"+AlipaySubmit.ALIPAY_GATEWAY_NEW;
	}
	
	@RequestMapping("json")
	@ResponseBody
	public Object getJson(){
		ResultObj res = new ResultObj();
		res.setContent("sdsad中文");
		return res;
	}
}
