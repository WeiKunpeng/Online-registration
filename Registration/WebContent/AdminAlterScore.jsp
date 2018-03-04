<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="Bean.ScoreBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改成绩</title>
    
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
			position:fixed;top:60%;left:75%;
		}
		
	</style>
  </head>
  

  <form  action="">
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
   <br></br><br></br><br></br>
     <%
  	ArrayList all = new ArrayList();
  	all = new ScoreBean().scoreform1();
  	if(all!=null)
  	{
  	Iterator it = all.iterator();  	
   %>
        <table align="center" width="400" height="200" border="1" style="position:fixed;top:40%;left:45%;">
    <tr>
    
    <td  witdh="10%"><div align="center">学号</div></td>
    <td  witdh="10%"><div align="center">姓名</div></td>
    <td  witdh="10%"><div align="center">考试编号</div></td>
    <td  witdh="10%"><div align="center">考试科目</div></td>
    <td  witdh="10%"><div align="center">是否修改</div></td>
 

    </tr>
    <%
    while(it.hasNext())
    {
    	 ScoreBean score = (ScoreBean)it.next();
     %>
    <tr>
 	<td  witdh="10%"><%=score.getSid()%></td>
 	<td  witdh="10%"><%=score.getSname()%></td>
 	<td  witdh="10%"><%=score.getTnumber()%></td>
 	<td  witdh="10%"><%=score.getTsubject()%></td>
 	<td  witdh="10%"><%=score.getScore()%></td>
 	<td witdh="10%"><a href = "AdminUpdateScore.jsp?sid=<%=score.getSid()%>&tnumber=<%=score.getTnumber()%>">修改</a></td>
    </tr>
    <%} }
    else {
    response.sendRedirect("index.jsp");
    }
    %>
    </table>
   </form>
  </body>
</html>
