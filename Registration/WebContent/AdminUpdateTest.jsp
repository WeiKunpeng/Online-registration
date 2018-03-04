<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="Bean.TestBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息修改</title>
    
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
		    width:200px;
		    float:left;
		    padding:5px;	      
		}
	
				p {
			font-size:25px;
			color:blue;
			position:fixed;
			top:70%;
			left:50%;
		}
		
	</style>
  </head>
  
  <form  action="/RegistrationTest/AdminUpdateTestServlet" method = "post">
  <div id="header"><h1 align:center>后台管理</h1></div>
 <div id="nav">
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
   
   <%
   String testnumber=request.getParameter("tnumber");
   TestBean test=new TestBean();
   test=test.showTest(testnumber);

   %>
      <br></br><br></br><br>
      
   <table align="center" width="500" height="250">
   <tr>
   <td>
  <input name="testnumber" type="hidden" value=<%=request.getParameter("tnumber")%> />
  </td>
   </tr>
   
   <tr>
   <td>考试编号</td>
   <td>
  <input name="number" type="text" value=<%=test.getNumber() %> />
  </td>
   </tr>
   <tr>
   <td>考试科目</td>
   <td>
  <input name="subject" type="text"  value=<%=test.getSubject() %> />
  </td>
   </tr>
    <tr><td>考试日期</td>
  <td>
  <input name="date" type="text" value=<%=test.getDate() %> />
  </td>
  </tr>
  <tr><td>考试时间</td>
  <td>
  <input name="time" type="text" value=<%=test.getTime() %> />
  </td>
  </tr>
  <tr><td>考试地点</td>
  <td>
  <input name="address" type="text" value=<%=test.getAddress() %> />
  </td>
  </tr>
   

   
    <p>
  <input type="submit" id="name" value="修改"/>
 </p>
   
   </table></form>
  </body>
</html>
