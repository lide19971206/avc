<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width,initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="resource/css/bootstrap.min.css">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>商店详情</h1>
	商店编号: ${shop.id}<br>
	商店名称: ${shop.name}<br>
	商店创建时间: ${shop.created}<br>
	商品信息: <c:forEach items="${shop.goods}" var="g">${g.name}</c:forEach>
</body>
</html>