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
    
    <title>成绩录入</title>
    
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
			position:fixed;top:60%;left:78%;
		}
		
	</style>
  </head>
  <form  action="/RegistrationTest/AdminEnterScoreServlet"method = "get">
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
  	all = (ArrayList)new ScoreBean().scoreform();
  	if(all!=null)
  	{
  	Iterator it = all.iterator();  	
   %>
        <table align="center" width="400" height="200" border="1" style="position:fixed;top:40%;left:45%;">
    <tr>
    
    <td  witdh="10%"><div align="center">学号</div></td>
    <td  witdh="10%"><div align="center">姓名</div></td>
    <td witdh="10%"><div align="center">考试编号</div></td>
    <td  witdh="10%"><div align="center">考试科目</div></td>
    <td  witdh="10%"><div align="center">成绩</div></td>

    </tr>
    <%
    int i = 0;
    while(it.hasNext()) //数组不为空
    {
    	 ScoreBean scores = (ScoreBean)it.next();
         String sequ = "score"+i;    //给每个成绩空编号	
         System.out.print("检测：顺序"+sequ);
     %>
    <tr>
 	<td  witdh="10%"><%=scores.getSid()%></td>
 	<td witdh="10%"><%=scores.getSname()%></td>
 	<td  witdh="10%"><%=scores.getTnumber()%></td>
 	<td  witdh="10%"><%=scores.getTsubject()%></td>
 	<td  witdh="10%"><input name=<%= sequ %> type="text" size="10"/></td> 
 	                                    <!-- 成绩已经输入-->
    </tr>
    <%i++;
    }
     }
    else {
    response.sendRedirect("index.jsp");
    }session.setAttribute("studentScores",all);
    %>
     <p><input type="submit" id="name" value="提交"/></p>
    </table>
   </form>
  </body>
</html>
