<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>滴滴打车后台管理控制中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <body background="images/bg1.jpg" style="text-align: center;padding-top: 150px">
	<form action="AdminServlet" method="post">
		<div style="background-image:url('images/bg2.jpg');height:243px;width:444px;margin:auto">
		<br><br><br><br><br>
		<table width="60%" border="0" cellpadding="0" cellspacing="0" style="margin-left:20%;margin-right:20%">
  			<tr height="40px">
    			<td width="40%" align=right>用户名:</td>
    			<td width="60%" align="left">&nbsp;<input id="name" type="text" name="name" style="width: 70%;left: 0px"></td>
    			<td>
	    			<select name="id">
						<option value="0">管理员</option>
						<option value="1">司机</option>
					</select>
				</td>
  			</tr>
  			<tr height="40px">
    			<td width="40%" align=right>密&nbsp;码:</td>
    			<td width="60%" align="left">&nbsp;<input id="password" type="password" name="password" style="width: 70%;left: 0px"></td>
  			</tr>
  		</table>
  		<div align="center">
			<input style="margin-left: auto;" type="submit" value="登陆"/>
			&nbsp;
		</div>
		</div>
	</form>
	</body>
</html>
