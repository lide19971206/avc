<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<input type="button" class="btn btn-link" onclick="goPage(1)"
	value="首页">
<input type="button" class="btn btn-link"
	onclick="goPage(${info.prePage==0?1:info.prePage })" value="上一页">
<input type="button" class="btn btn-link"
	onclick="goPage(${info.nextPage ==0?info.pages:info.nextPage})"
	value="下一页">
<input type="button" class="btn btn-link"  onclick="goPage(${info.pages})"
	value="尾页">
	${info.pageNum}/${info.pages}

