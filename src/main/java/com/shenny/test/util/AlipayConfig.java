package com.shenny.test.util;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088021062639229";
	
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static String seller_id = partner;
	// 商户的私钥
	public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMeDMEy37YZRvaiXM6OlxQ97L3BBVPcSGJQpBto/140cHGkhbAdZLhffPV+VRBjH24R0VZRQeu/sH97JqgXWtRFHCU976Gc+N6SVs80CzqgHFtY9fSIuA7qTvbtLUO2Dff7et0C+UL+2jw4mYofj+tW6QFlLo9sVs0CHMJhsPhmJAgMBAAECgYA3jtbCZm2ke9q+uexNY/ouR3V8YxUQAGAL0ijwWdrilrNqqz30BeeKCkaC+YQPCoicp/C07nxtl2mAltPb8GBXQ2LFAUQlMhpUG2OdNJgC4Q6YRYbPvue1lSL3IQ7J8hXf2A76x4OfZ4ou3LchwZcJiqg4CqxmbMWJCy0i3jCgAQJBAOs0Ev7kydO/UQYild5pa0PPtfV++p2lSq679ZLTD+6G3SyiHBZFj4CWm1r9VvRi2YIJiD+ZbrO3eNr4ZOE414kCQQDZJzwms5Fu2m5batP+XTiYgGxkZaitE5utHTTKDhv2p5jmwgh7g93+dLKM6tZrx/ia1IC2sRwLoaR7ZtPp6LIBAkEAlJx9mCJ1R96tUkQOD87qIJmgbfKCZZNoAcnvW4sSmPML0sTHHGdtSaFfnflOtPG0Xw6o0Q6gPNujeC/Uhd4FiQJAV3cLLldzg5/thVrRCopHyn0nq4Sa3SOht6ek5KGsN7wnxQJwYjeqCdy9Mi9AsGb6RnrDYVKTBkhUNPQk9PkqAQJAeHmECDCMwHg4NdHtWFfiGYNlK2swYHRuy5n/Awb2Os8WcneKzf7Hx7nHTURhTzqXbOsz8oYAqOID+le4kT616A==";
	
	// 支付宝的公钥，无需修改该值
	public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "RSA";

}
