<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>车辆查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form action="CarSelectServlet" method="post">
  	<div style="width:70%;margin-left:10%;margin-right:10%">
  		<br><br><br><br><br><br><br><br><br>
  		<table width="90%" border="0" cellpadding="0" cellspacing="0" style="margin-left:20%;margin-right:20%">
  			<tr height="40px">
    			<td width="40%" align=right>请输入要查询的车牌号:</td>
    			<td width="60%" align="left">&nbsp;<input id="select_update_username" type="text" name="carnumber" style="width: 60%;margin-left: 0px"></td>
  			</tr>
  		</table>
  		<div align="center">
			<input style="margin-left: auto;" type="submit" value="确定"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="清除"/>
		</div>
  		<br><br><br><br><br><br>
  	</div>
  	</form>
  </body>
</html>
