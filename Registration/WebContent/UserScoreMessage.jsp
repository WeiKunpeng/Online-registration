<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>成绩显示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style type="text/css">
		body{
			background-image:url(picture/1.jpg);
			background-size:cover; 
		}
		p{
			font-size:30px;
			position:fixed;
			top:25%;
			left:30%;
		}
		table{
			align="center";
			width="450";
			height="117";
			border-style: solid; 
			border-width: 1px;
			border-collapse:collapse;
			position:fixed;
			top:40%;
			left:30%;
		}
		a{ 
			 font-size:20px;
			position:fixed;
			top:65%;
			left:70%;
			color:black;
		}
	</style>
  </head>
  
   <div >
  <body>
  <p>本学期您的成绩：</p>
   <br></br><br></br><br>
   <table align="center" width="500" height="200" border="1">
   <tr> <td>学号</td>
   <td><%=session.getAttribute("sid")%></td> </tr>
   
   <tr><td>姓名</td>
  <td> <%=session.getAttribute("sname") %></td>
  </tr>
 
  <tr><td>考试编号</td>
  <td><%=session.getAttribute("tnumber")%></td>
  </tr>
  <tr><td>考试科目</td>
  <td> <%=session.getAttribute("tsubject") %></td>
  </tr>
   <tr>
   <td>成绩</td>
   <td><%=session.getAttribute("score")%> </td>
   </tr>
</table>
<a href="UserSelect.jsp?sid=<%=session.getAttribute("sid")%>">返回首页</a>
</form>
  </body></div>
</html>
