<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>热点</title>
</head>
<style type="text/css">
body {
	margin: 20px;
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
</style>
<body>
	<table border="1" align="center">
		<c:forEach items="${news}" var="a">
			<tr>
				<td>${a}</td>
			</tr>
		</c:forEach>
		<c:forEach items="${hotKeyword}" var="a">
			<tr>
				<td>${a}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>