<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h1>登录</h1>
  	<c:if test="${message != ''}">
  		${message }
  	</c:if>
  	
    <form action="${pageContext.request.contextPath }/loginRequest" method="POST">
    	<table width="100%" border=0>
    		<tr>
    			<td>用户名：<input type="text" name="username" value=""></td>
    		</tr>
    		<tr>
    			<td>密码：<input type="text" name="userpwd" value=""></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="登录"></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
