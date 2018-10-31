<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加产品</title>
    
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
  	<h1>添加产品</h1>
    <form action="${pageContext.request.contextPath }/addItem" method="POST" enctype="multipart/form-data">
    	<table width="100%" border=1>
    	 	<tr>
    	 		<td>产品名称<input type="text" name="name"></td>
    	 	</tr>
    	 	<tr>
    	 		<td>产品价格<input type="text" name="price"></td>
    	 	</tr>
    	 	<tr>
    	 		<td>产品图片<input type="file" name="file"></td>
    	 	</tr>
    	 	<tr>
    	 		<td>产品描述<input type="text" name="detail"></td>
    	 	</tr>
    	 	<tr>
    	 		<td><input type="submit" value="提交"> </td>
    	 	</tr>
    	</table>    	
    </form>
  </body>
</html>
