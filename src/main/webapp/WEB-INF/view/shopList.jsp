<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<h1>商店系统</h1>
	<table>
		<tr>
			<td colspan="100">
				<form action="list" id="forms">
					销售商品:
					
					<c:forEach items="${goods}" var="g">
						<input type="checkbox" value="${g.id}" name="gname"<c:forEach items="${vo.gname}" var="id">
						<c:if test="${id==g.id}">checked="checked"</c:if>
					</c:forEach>>${g.name}
					</c:forEach><br>
					店铺名称:<input type="text" name="name" value="${vo.name}">
					<input type="hidden" name="pageNum" id="pageNum">
					<input type="submit" value="查询">
					<input type="button" value="添加" onclick="addShop()">
					<input type="button" value="批量删除" onclick="del()">
				</form>
			</td>
		</tr>
		<tr>
			<td><input type="checkbox" id="cks"></td>
			<td>编号</td>
			<td>店铺名称</td>
			<td>创建日期</td>
			<td>销售商品</td>
			<td>操作</td>
		</tr>
			<c:forEach items="${shops}" var="s">
			<tr>
				<td><input type="checkbox" class="ck" value="${s.id}"></td>
				<td>${s.id}</td>
				<td>${s.name}</td>
				<td>${s.created}</td>
				<td>
					<c:forEach items="${s.goods}" var="sg">
						${sg.name}
					</c:forEach>
				</td>
				<td><input type="button" value="详情" onclick="readAll(${s.id})"></td>
				</tr>
			</c:forEach>
		<tr>
			<td colspan="100">
				<jsp:include page="pages.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function readAll(id){
		location.href="selectShopById?id="+id
	}
	function goPage(pageNum){
		$("#pageNum").val(pageNum)
		$("#forms").submit()
	}
	function addShop(){
		location.href="addShop"
	}
	$("#cks").click(function(){
		$(".ck").each(function(){
			this.checked= $("#cks").prop("checked")
		})
	})
	function del(){
		var ids= $(".ck:checked").map(function(){
			return this.value
		}).get().join(",")
		if (confirm("确定删除编号为【"+ids+"】的商店吗")) {
			$.ajax({
				url:"del",
				data:{"ids":ids},
				dataType:"json",
				success:function(obj){
					if (obj) {
						location.href="list"
					} else {
						alert("删除失败")
					}
				}
				
			})
		}
	}
</script>
</html>