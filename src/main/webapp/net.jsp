<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>营业网点</title>
<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>


<script type="text/javascript">
	var preIndex=-1;
	var bannerIndex = 0;
	var intervalObj;
	$(function() {

		$(".wrap .tab:first").show();
		$(".border").css({
			"width" : $(".nav li:first").width() + 20,
			"height" : $(".nav li:first").height() + 20
		});
		$(".nav li").not(".border").click(function() {
			var offset = $(this).offset().left;
			$(".nav .border").animate({
				"left" : offset,
				"top" : $(this).offset().top
			}, 400);
			var index = $(this).index();
			$(".wrap .tab").hide();
			$(".wrap .tab").eq(index).fadeIn(400);
		});
		$(".banner li").each(function(i) {
			$(".bannerNav").append("<i></i>");
		});	
		changePic();
		$(".banner ul").height($(".banner li:first").height());
		$(".banner ul").width($(".banner li:first").width());
		intervalObj = setInterval(timer, 5000);
		$(".bannerNav i").click(function() {
			clearInterval(intervalObj);
			preIndex=bannerIndex;
			bannerIndex = $(this).index();
			changePic(2);
			intervalObj = setInterval(timer, 5000);
		});
	});

	function changePic(type) {
		if(preIndex<0)
			$(".banner li").eq(bannerIndex).show();
		else if(type==1){
			$(".banner li").eq(preIndex).fadeOut(2000);
			$(".banner li").eq(bannerIndex).css({"position":"absolute","top":0,"left":0}).fadeIn(2000);
		}
		else if(type==2)
			{
			$(".banner li").eq(preIndex).slideUp();
			$(".banner li").eq(bannerIndex).slideDown();
		}
		else{
			$(".banner li").eq(preIndex).hide();
			$(".banner li").eq(bannerIndex).show();
		}
		$(".bannerNav i").removeClass("active");
		$(".bannerNav i").eq(bannerIndex).addClass("active");
	}

	function timer() {
		preIndex=bannerIndex++;
		if (bannerIndex == $(".banner li").length)
			bannerIndex = 0;
		changePic();
	}
</script>
<style type="text/css">
body {
	padding: 0;
	margin: 0;
	font-family: "微软雅黑";
	box-sizing: border-box;
}

.nav {
	
}

.nav ul {
	padding: 0;
	margin: 0;
	list-style: none;
	display: -webkit-box;
	position: relative;
	box-sizing: border-box;
}

.nav li {
	-webkit-box-flex: 1;
	text-align: center;
	padding: 10px;
	box-sizing: border-box;
	cursor: pointer;
	font-size: .9em;
}

.wrap {
	margin: 0 auto;
	max-width: 800px;
	padding: 2em;
	background-color: #eee;
}

.border {
	border-bottom: 2px solid #000;
	position: absolute;
	top: 0;
	left: 0;
}

.tab {
	text-align: center;
	display: none;
}

.banner {
	margin-bottom: 10px;
	position: relative;
	overflow:hidden;
}

.banner ul {
	padding: 0;
	margin: 0;
	list-style: none;
	width: 100%;
	position: relative;
}

.banner li {
	display: none;
	max-width:100%;
	max-height:100%;
}

img {
	max-width: 100%;
}

.bannerNav {
	text-align: center;
}

.bannerNav {
	position: absolute;
	bottom: 0;
	left: 0;
	width: 100%;
	margin-bottom: 8px;
}

.bannerNav i {
	padding: 6px;
	border-radius: 6px;
	background-color: rgba(100, 100, 100, 0.8);
	color: #fff;
	margin: 0 10px;
	display: inline-block;
	cursor: pointer;
}

.active {
	background-color: rgba(0, 0, 0, 0.8) !important;
}
</style>
</head>
<body>
	<div class="nav">
		<ul>
			<li>导航一</li>
			<li>导航一</li>
			<li>导航一</li>
			<li>导航一</li>
			<li class="border"></li>
		</ul>

	</div>
	<div class="wrap">
		<div class="banner">
			<ul>
				<li><img
					src="http://www.jq22.com/demo/jquery-lbt20151027/images/slide-1.jpg"></li>
				<li><img
					src="http://www.jq22.com/demo/jquery-lbt20151027/images/slide-2.jpg"></li>
				<li><img
					src="http://www.jq22.com/demo/jquery-lbt20151027/images/slide-3.jpg"></li>
				<li><img
					src="http://www.jq22.com/demo/jquery-lbt20151027/images/slide-4.jpg"></li>
					<li><img
					src="http://www.jq22.com/demo/jquery-lbt20151027/images/slide-5.jpg"></li>
			</ul>
			<p class="bannerNav"></p>
		</div>
		<div class="tab">tab1</div>
		<div class="tab">tab2</div>
		<div class="tab">tab3</div>
		<div class="tab">tab4</div>
	</div>
</body>
</html>