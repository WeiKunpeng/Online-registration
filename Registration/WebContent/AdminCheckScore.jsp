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

	<style type="text/css">
	#header {
			background-color:black;
    		color:white;
    		text-align:center;
    		padding:5px;
		}
		#nav {
		    line-height:30px;
		    background-color:#eeeeee;
		    height:600px;
		    width:150px;
		    float:left;
		    padding:5px;	      
		}
	
	</style>
  </head>
  
    <div id="header"><h1 align:center>后台管理</h1></div>
 <div id="nav">
   <form  action="/RegistrationTest/AdminCheckScoreServlet" method = "post">
<font size="4" color=blue>考生信息管理</font><br></br>
    <a href="AdminCheckMessage.jsp"> 信息查询 </a><br></br>
    <a href="AdminAlterMessage.jsp"> 信息修改 </a><br></br>
    
    <font size="4" color=blue>考试信息管理</font><br></br>
    <a href="AdminCheckTest.jsp"> 信息查询 </a><br></br>
    <a href="AdminAlterTest.jsp"> 信息修改 </a><br></br>
    <a href="AdminInsertTest.jsp"> 增加考试 </a><br></br>
    
    <font size="4" color=blue>考生成绩管理</font><br></br>
    <a href="AdminCheckScore.jsp"> 成绩查询 </a><br></br>
   <!--   <a href="AdminFillInScore.jsp"> 成绩录入 </a><br></br>-->
    <a href="AdminAlterScore.jsp"> 修改成绩 </a><br></br>
</div>
   <br></br>
   <body>
   <div align="center"> <font size="6" color=blue>输入考生学号和考试编号查询考生成绩</font><br></br></div>
   <table align="center" width="300" height="200">
   <tr>
   <td>考生学号</td>
   <td>
  <input name="id" type="text"  />
  </td>
   </tr>
   
   
   <tr>
   <td>考试编号</td>
   <td>
  <input name="number" type="text"  />
  </td>
  </tr>
   <div align="center"> <font size="6" color=blue>任选一项输入查询，也可以都输入</font><br></br></div>
    <tr> 
   <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="submit" id="name" value="提交"/>
  </td>
  <td>&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="reset" id="name" value="取消"/>
  </td>
   </tr>
   </table></form>
  </body>
</html>
