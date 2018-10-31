<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/queryItems" method="post">
	
	<h1>商品列表</h1>
	<a href="${pageContext.request.contextPath }/logoutRequest">退出</a>
	<table width="100%" border=1>
		<tr>
			<td colspan="10">查询条件</td>
		</tr>
		<tr>
			<td colspan="10">
				名称：<input type="text" name="name">
				价格：<input type="text" name="price">
				<input type="submit" value="查询">
				<input type="button" onClick="javascript:window.location.href='${pageContext.request.contextPath}/addItemView'" value="添加">
			</td>
		</tr>
		<tr>
			<td>商品序号</td> 
			<td>商品名称</td> 
			<td>商品价格</td> 
			<td>商品图片</td>
			<td>生产日期</td> 
			<td>商品描述</td> 
			<td>商品编辑</td>
		</tr>
		<c:forEach items="${itemList }" var="item">
			<tr>
				<td>${item.id }</td>
				<td>${item.name }</td>
				<td>${item.price }</td>
				<td>
					<c:if test="${item.pic != null }">
						<img src="/img/${item.pic }" width=100 height=100>
						<br />
					</c:if>				
				</td>
				<td><fmt:formatDate value="${item.createtime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${item.detail }</td>
				<td>
					<a href="${pageContext.request.contextPath}/updateItem">修改</a>
					<a href="${pageContext.request.contextPath}/deleteItem">删除</a>
				</td>
				
			</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>