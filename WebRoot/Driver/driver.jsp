<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'driver.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  		String name = (String)session.getAttribute("username");
  		session.setAttribute("username", name);
  		System.out.println("in driver.jsp name = " + name);
  	 %>
  	
	<frameset rows="150,*">
	<frame src="Driver/dtop.jsp" scrolling="no">
	<frameset cols="160,*">
		<frame src="Driver/dleft.jsp" scrolling="no">
		<frame src="Driver/dright.jsp" name="main">
	</frameset>
</frameset>
</html>
