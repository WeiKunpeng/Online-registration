<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>成绩查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<style>
	body{
	
		background-image:url(picture/1.jpg);
		background-size:cover; 
	}
	p {
		position:fixed;
		top:50%;left:52%;
	
	}
</style>
  </head>
  
   <a style="font-size:40px;position:fixed;top:20%;left:43%;"><font >成绩查询系统</font></a>
  <body >
   <form action="/RegistrationTest/UserCheckScoreServlet" method = "post">
   <br></br><br></br><br>
  
   <table align="center" width="300" height="117" style="font-size:20px;position:fixed;top:33%;left:40%;">
   <tr>
   <td>学号</td>
   <td><input name="id" type="text" size="20" ></td>
   </tr>
    
    <tr>
   <td>考试编号</td>
   <td><input name="number" type="text" size="20" ></td>
   </tr>
  
   <p><input type="submit" value="提交" ></p>
  
   </table>
   </form>
  </body>
</html>
