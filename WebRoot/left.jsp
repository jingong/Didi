<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body bgcolor="#ACD6FF" style="padding-left: 15px">
	<br>
	<h4>欢迎使用</h4>
	<br>

	<p>
		<a href="right.jsp" target="main">指挥中心</a>
	</p>

	<p>
		<a href="driver_register.jsp" target="main">司机注册</a>
	</p>
	
	<p>
		<a href="sijixinxiupdate.jsp" target="main">司机信息修改</a>
	</p>
	
	<p>
		<a href="sijixinxi.jsp" target="main">查看司机信息</a>
	</p>
	
	<p>
		<a href="driver_cancel.jsp" target="main">司机注销</a>
	</p>
	
	<p>
		<a href="car_register.jsp" target="main">车辆注册</a>
	</p>
	
	<p>
		<a href="car_select.jsp" target="main">车辆查询</a>
	</p>
	
	<p>
		<a href="sijichuqin.jsp" target="main">司机出勤情况</a>
	</p>

</body>
</html>
