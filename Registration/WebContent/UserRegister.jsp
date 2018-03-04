<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
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
	table{
	
		position:fixed;
		top:40%;left:45%;
	}
	</style>

  </head>
  

  <a style="font-size:40px;position:fixed;top:20%;left:50%;"><font >用户注册</font></a>
   <div style="width:30%;height:30%;margin:10px 0 0 0px ;border:2px solid black;position:fixed;top:35%;left:40%;text-align:center"><body  >
   <form action="/RegistrationTest/UserRegisterServlet" method = "post">
   <br></br><br></br><br>
   <table >

   <tr>
   <td>  &nbsp; &nbsp;&nbsp; &nbsp;学号 &nbsp; &nbsp; &nbsp;</td>
   <td>
  <input name="id" type="text" />
  </td>
   </tr>
   <tr>
   <td>  &nbsp; &nbsp;&nbsp; &nbsp;姓名 &nbsp; &nbsp; &nbsp;</td>
   <td>
  <input name="username" type="text" />
  </td>
   </tr>
   
   <tr>
   <td>  &nbsp; &nbsp;&nbsp; &nbsp;密码 &nbsp; &nbsp; &nbsp;</td>
   <td>
  <input name="password" type="password"/>
  </td>
   </tr>
<tr>
   <td>  &nbsp; &nbsp;&nbsp; &nbsp;性别 &nbsp; &nbsp; &nbsp;</td>
   <td>
  <input name="sex" type="text"/>
  </td>
   </tr>
   <p>
</br></br>
<input type="submit" id="name" value="注册"/>
  &nbsp; &nbsp;
<input type="reset" id="name" value="重置"/>
  </p>
   
   </table></form>
  </body></div>
</html>
