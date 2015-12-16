<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>热点2</title>
</head>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script type="text/javascript">
	var color = [ '#FF9966', '#FF6666', '#FFCCCC', '#CC9966', '#666666',
			'#CC9999', '#FF6666', '#FFFF66', '#99CC66', '#CC3333', '#CCCCCC',
			'#003366', '#993333', '#CCCC00', '#663366', '#CCCC99', '#666666',
			'#CC9999', '#FF6666', '#FFFF00', '#0066CC', '#CC0033', '#333333',
			'#CCCC00', '#336633', '#990033', '#FFCC99', '#993333', '#CC9966',
			'#003300', '#FF0033', '#333399', '#CCCC00' ];

	var now = "${date}";

	$(function() {
		btnInit();
		$(".wrap li").each(function() {
			$(this).css({
				"background-color" : color[getRandom(color.length)],
				"left" : 150 - getRandom(300),
				"top" : 150 - getRandom(300),
				"opacity" : 0
			});
		});
		$(".wrap").show();
		$(".wrap li").animate({
			"left" : 0,
			"top" : 0,
			"opacity" : 0.85
		}, 1000);
		$(".wrap li").hover(function() {
			$(this).css({
				"transition" : "all 0.5s",
				"transform" : "scale(2)"
			});
		}, function() {
			$(this).css({
				"transform" : "scale(1)"
			});
		});
		$(".wrap li").click(
				function() {
					window.open("http://news.baidu.com/ns?tn=news&word="
							+ encodeURIComponent($(this).text()));
				});
	});
	function getRandom(num) {
		return Math.floor(Math.random() * num);
	}

	function btnInit() {
		var currDate = new Date();
		var todayStr = currDate.getFullYear()
				+ ""
				+ (currDate.getMonth() > 8 ? currDate.getMonth() + 1 : "0"
						+ (currDate.getMonth() + 1))
				+ ""
				+ (currDate.getDate() > 9 ? currDate.getDate() : "0"
						+ currDate.getDate());
		if (now == '' || todayStr <= now)
			$("a").eq(1).addClass("disabled").attr("href",
					"#");
	}
	function pageChange(isNextDay) {
		var currDate = new Date();
		if (now != '') {
			currDate.setFullYear(now.substr(0, 4));
			currDate.setMonth(eval(now.substr(4, 2)) - 1);
			currDate.setDate(now.substr(6, 2));
		}
		if (isNextDay)
			currDate.setDate(currDate.getDate() + 1)
		else
			currDate.setDate(currDate.getDate() - 1)
		window.location.href = "/test/index.htm?v=2&date="
				+ currDate.getFullYear()
				+ ""
				+ (currDate.getMonth() > 8 ? currDate.getMonth() + 1 : "0"
						+ (currDate.getMonth() + 1))
				+ ""
				+ (currDate.getDate() > 9 ? currDate.getDate() : "0"
						+ currDate.getDate());

	}
</script>
<style type="text/css">
body {
	padding: 0px;
	margin: 0px;
	font-family: "微软雅黑";
	font-size: 14px;
}

table {
	border-collapse: collapse;
	border-color: #eee;
	border-radius: 10px;
}

td {
	padding: 5px;
}

tr:nth-child(odd) {
	background-color: #eee;
}

tr:hover {
	background-color: #ddd;
}

.wrap {
	margin: 0 auto;
	padding: 20px;
	max-width: 800px;
	width:800px;
}

.pannel {
	padding: 20px;
	background-color: #eee;
}

ul {
	list-style: none;
	margin: 0;
	padding: 0;
	overflow:hidden;
}

li {
	padding: 10px;
	margin: 10px;
	position: relative;
	float: left;
	background-color: #0099CC;
	color: #fff;
	//font-weight: bolder;
	border-radius: 20px;
	z-index: 1;
	box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.2);
}

li:hover {
	z-index: 999;
}

.btn {
	width: 50%;
	float: left;
	border: 10px solid #fff;
	display: block;
	padding: 8px;
	text-align: center;
	box-sizing: border-box;
	color: #fff;
	background-color: #0099cc;
	border-radius: 20px;
	transition: all 0.3s;
}

.btn:hover {
	background-color: #336699;
}

.disabled {
	background-color: #ccc;
}

.disabled:hover {
	background-color: #ccc;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}
</style>
<body>
	<div class="wrap" style="display: none;">
		<div class="pannel">
			<ul>
				<c:forEach items="${hotKeyword}" var="a">
					<li title="点击搜索【${a}】">${a}</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div
		style="text-align: center; position: fixed; left: 0; bottom: 0; width: 100%; height: 50px;">
		<a class="btn" href="javascript:pageChange(false);">前一天</a> <a
			class="btn" href="javascript:pageChange(true);">后一天</a>
	</div>

</body>
</html>