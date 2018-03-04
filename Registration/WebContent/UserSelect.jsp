<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="Bean.UserLoginBean"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户主页面</title>
    
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
		    height:500px;
		    width:150px;
		    float:left;
		    padding:5px;	      
		}
	
				p {
			font-size:25px;
			color:blue;
		}
		
	</style>
  </head>
   <%
    UserLoginBean user=new UserLoginBean();
    String id=request.getParameter("sid");
    user=user.showStudent(id);
    %>
    <div id="header"><h1 align:center>欢迎进入网上报名系统</h1></div>
 <div id="nav">
<a href="UserTest.jsp?sid=<%=user.getId() %>"> 考试报名 </a><br></br>

          <a href="UserCheckScore.jsp"> 成绩查询 </a><br></br>
</div>
    <form>
   
    
    
    <table align="center" width="300" height="300" border="1" style="position:fixed;top:20%;left:45%;">

    <tr> <td>姓名</td><td><%=user.getName()%></td> </tr>
     <tr><td>学号</td>
  <td> <%=user.getId() %></td>
  </tr>
    <tr><td>性别</td>
  <td> <%=user.getSex() %></td>
  </tr>

   </table>

 
      
    </form>
     
  </body>
</html>
