
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询错误
    </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		p {
			font-size:25px;
		}
	</style>
  </head>
   <body >
<img src="picture/timg.gif" alt="Smiley face" width="100" height="100" style="position:fixed;top:5%;left:52%;text-align:center">
<div style="width:30%;position:fixed;top:20%;left:42%;text-align:center"> 
   </br>
   <table>
  
   <p style="font-szie:100px;">查询错误...</p>
   <p>点击此处<a href="AdminCheckMessage.jsp">返回查看页面</a></p>
   </br>
   </table>
   </div>
  </body>
</html>
