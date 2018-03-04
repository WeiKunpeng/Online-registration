<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="Bean.TestBean"%>
<%@page import="Bean.CheckBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>考试报名</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <div align="center"> <font size="12" color=blue style="position:fixed;left:45%;">考试报名</font><br></br></div>
  <body style="background-image:url(picture/1.jpg);background-size:cover;">
  <form action="/RegistrationTest/TestServlet" method = "post">
   <br></br><br></br><br>
   <table align="center" width="600" height="200">

   <%
   String stuid=request.getParameter("sid");
   System.out.println("检测："+stuid);
  	ArrayList alltest = new ArrayList();
  	ArrayList all = new ArrayList();
  	alltest = new TestBean().showTest();
  	all=new CheckBean().checkId(stuid);
  	%>
  	<font size="8" color=blue align="center" style="position:fixed;top:20%;left:40%;">已报名考试信息</font><br></br>
  	<%
  	if(all!=null)
  	{
  	Iterator it = all.iterator();
  	
   %>

         <table cellspacing="0" cellpadding="0" align="center" width="400" height="80" border="1" style="position:fixed;top:35%;left:35%;">
   
    <tr>
    <td  witdh="5%"><div align="center">考试编号</div></td>
    <td  witdh="5%"><div align="center">考试科目</div></td>
<tr><tr><tr><tr>
 </tr></tr></tr></tr>
    </tr>
    <%
    while(it.hasNext())
    {
    	 CheckBean score = (CheckBean)it.next();   ////next后移
     %>
    <tr>
 	<td  witdh="10%"><%=score.getTnumber()%></td>
 	<td  witdh="10%"><%=score.getTsubject()%></td>
    </tr>
    <%} }%>
    
   <font size="8" color=blue align="center" style="position:fixed;top:60%;left:45%;">考试信息</font><br></br>
  	<%
  	if(alltest!=null)
  	{
  	Iterator it = alltest.iterator();  	
   %>
        <table cellspacing="0" cellpadding="0" align="center" width="600" height="80" border="1" style="position:fixed;top:70%;left:30%;">
    <tr>
    
    <td  witdh="10%"><div align="center">考试编号</div></td>
    <td  witdh="10%"><div align="center">考试科目</div></td>
    <td  witdh="10%"><div align="center">考试日期</div></td>
    <td witdh="10%"><div align="center">考试时间</div></td>
    <td  witdh="10%"><div align="center">考试地点</div></td>
    <td  witdh="10%"><div align="center">是否报名</div></td>
 

    </tr>
    <%
    while(it.hasNext())
    {
    	TestBean test = (TestBean)it.next();
     %>
    <tr>
 	<td  witdh="10%"><%=test.getNumber()%></td>
 	<td  witdh="10%"><%=test.getSubject()%></td>
 	<td  witdh="10%"><%=test.getDate()%></td>
 	<td  witdh="10%"><%=test.getTime()%></td>
 	<td  witdh="10%"><%=test.getAddress()%></td>
 	<td  witdh="10%"><a href = "UserTestSelect.jsp?sid=<%=request.getParameter("sid")%>&tnumber=<%=test.getNumber()%>">报名</a></td>
    </tr>
    <%} }
    else {
    response.sendRedirect("index.jsp");
    }
    %>
    </table>

  
     </table>
     </form>
  </body>
</html>
