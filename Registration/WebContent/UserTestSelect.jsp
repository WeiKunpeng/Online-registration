<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="Bean.CheckBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>¿¼ÊÔ±¨Ãû</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
 

   <%
   CheckBean s_test=new CheckBean(); 
   String sid=request.getParameter("sid");
   String tnumber=request.getParameter("tnumber");
   String result=s_test.insert(sid,tnumber);
 	if(result.equals("true"))
 	{
 		response.sendRedirect("UserTestSuccess.jsp?sid="+sid+"&tnumber="+tnumber);
 	}
 	else
 	{
 		response.sendRedirect("UserTestError.jsp?sid="+sid+"&tnumber="+tnumber);
 	}
   %>
 
   

  </body>
</html>
