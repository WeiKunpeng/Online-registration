<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<style type="text/css">
		div{
			position:fixed;
			top:20%;
			left:30%;
		}
		p{
			position:fixed;
			top:55%;
			left:40%;
		}
</style>
  </head>
   <div align="center"> <font size="12" color=blue>网上报名后台管理系统</font><br></br><br></br></div>
  <body style="background-image:url(picture/1.jpg);background-size:cover;">
    <form action="/RegistrationTest/AdminLoginServlet" method = "post">
    <br></br><br></br><br></br><br></br>
    <table align="center" width="300" height="150" style="position:fixed;top:33%;left:35%;text-align:center">
   <tr>
   <td>管理员名</td>
   <td>
  <input name="adminname" type="text" size="22"/>
  </td>
   </tr>
   
   <tr><td>密码</td>
  <td>
  <input name="password" type="password" size="22" />
  </td>
  </tr>
  
   <p>
  <input type="submit" id="name" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="reset" id="name" value="重置"/>
  </p>
   
    </table>
    </form>
  </body>
</html>
