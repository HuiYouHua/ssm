<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>json交互测试</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.10.1.js"></script>
    <script type="text/javascript">
        //请求json，输出是json
        function requestJson(){   
          	$.ajax({
          		type: 'post',
          		url: '${pageContext.request.contextPath }/requestJson',
          		contentType: 'application/json;charset=utf-8',
          		data: '{"name": "樱桃", "price": "20"}',
          		success: function(data) {
          			var str="";
          			data.forEach(function(value, index) {
          				str += value.name + " " + value.price + "\r\n";
          			});
          			alert(str);
          		}
          	});
        }
        //请求key/value，输出是json
        function responseJson(){    
        	$.ajax({
		        type:'post',
		        url:'${pageContext.request.contextPath }/responseJson.action',
		        //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
		        //contentType:'application/json;charset=utf-8',
		        //数据格式是json串，商品信息
		        data:'name=樱桃&price=20',
		        success:function(data){//返回json结果
          			alert(data.name + " " + data.price);
		        }

   			 });
        }
    </script>
  </head>
  
  <body>
    <input type="button" onclick="requestJson()" value="请求json，输出是json"/>
	<input type="button" onclick="responseJson()" value="请求key/value，输出是json"/>
  </body>
</html>
