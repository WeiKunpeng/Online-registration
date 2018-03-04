<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style>
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
	
				p {
		position:fixed;
		top:65%;left:45%;
	
	}
		
	</style>
  </head>
  
    <div id="header"><h1 align:center>后台管理</h1></div>
 <div id="nav">
   <form  action="/RegistrationTest/AdminCheckMessageServlet" method = "post">
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
  <body>
  <div style="position:fixed;top:20%;left:35%;text-align:center"> 
   </br>
   </table>
   <br></br><br></br><br></br>
   <table align="center" width="400" height="100">
   <font size="6" color=blue>请输入学生学号</font><br></br>
   <tr>
   <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学号</td>
   <td>
  <input name="studentid" type="text"  />
  </td>
   </tr>
   
   </table></div>
   <p> 
  <input type="submit" id="name" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="reset" id="name" value="取消"/>
</p>
   </form>
  </body>
</html>
