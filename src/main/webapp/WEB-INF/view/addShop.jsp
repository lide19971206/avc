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
<h1>商店添加页面</h1>
	<form id="forms">
		编号:<input type="text" name = "id" ${vo.id}><br>
		店铺名称:<input type="text" name = "name" ><br>
		创建日期:<input type="text" name = "created" ><br>
		销售商品:
		<c:forEach items="${list}" var="goods">
			<input type="checkbox" value="${goods.id}" name="gname">${goods.name}
		</c:forEach><br>
		<input type="button" value="添加" onclick="add()">
	</form>
</body>
<script type="text/javascript"> 
	function add(){
		$.ajax({
			url:"add",
			data:$("#forms").serialize(),
			dataType:"json",
			success:function(obj){
				if (obj) {
					location.href="list"
				} else {
					alert("添加失败")
				}
			}
			
		})
	}
</script>
</html>