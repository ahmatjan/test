<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>支付宝支付页面</title>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("[name=WIDout_trade_no]").val(Math.floor(Math.random()*1000000000));
	});
	
	function submit(){
		$("form").submit();
	}
</script>
<style type="text/css">
body {
	font-size: 13px;
	font-family: "微软雅黑";
	padding: 0;
	margin: 0;
}

.header {
	text-align: center;
	font-size: 16px;
	padding: 5px;
	border-bottom: 1px solid #eee;
}

.wrap {
	padding: 10px;
}

.content {
	max-width: 500px;
	margin: 5px auto;
	padding: 20px;
	border: 1px solid #eee;
	border-radius: 8px;
}

ul {
	list-style: none;
	padding: 0;
}

ul li {
	padding: 5px;
}

a{
	text-decoration:none;
}
.btn {
	display: inline-block;
	border-radius: 5px;
	border: 1px solid #eee;
	padding:5px 10px;
	background-color:#00C5FF;
	color:#fff;
}
</style>
</head>
<body>
	<div class="header">支付宝测试页面</div>
	<div class="wrap">
		<div class="content">
			<form action="pay.htm" method="get" target="_blank">
				<ul>
					<li>订单编号:<input size="30" type="text" name="WIDout_trade_no" /></li>
					<li>订单名称:<input size="30" type="text" name="WIDsubject" value="支付宝测试商品" /></li>
					<li>付款金额:<input size="30" name="WIDtotal_fee" value="0.01"/></li>
					<li>商品地址:<input size="30" name="WIDshow_url" value="http://www.baidu.com" /></li>
				</ul>

				<a class="btn" href="javascript:submit();">提交</a>
			</form>
		</div>
	</div>
</body>
</html>