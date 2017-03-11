<%@page import="entity.Driver"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatedriver.jsp' starting page</title>
    
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
    <%
    	Driver driver = (Driver)session.getAttribute("driver");
    	if(driver == null){
    		response.sendRedirect(path+"/sijixinxiupdate.jsp");
    	}
     %>
     <form action="UpdateDriverServlet" method="post">
  	<div style="width:80%;margin-left:10%;margin-right:10%">
  		<br><br><br>
  		<table width="60%" border="0" cellpadding="0" cellspacing="0" style="margin-left:20%;margin-right:20%">
  			<tr height="40px">
    			<td width="40%" align=right>用户名:</td>
    			<td width="60%" align="left">&nbsp;<input id="update_username" readonly="true" type="text" name="username" style="width: 60%;left: 0px" value="<%=driver.getUsername() %>"></td>
  			</tr>
  			<tr height="40px">
    			<td width="40%" align=right>姓名:</td>
    			<td width="60%" align="left">&nbsp;<input id="update_name" type="text" name="name" style="width: 60%;left: 0px" value="<%=driver.getName() %>"></td>
  			</tr>
  			<tr height="40px">
    			<td width="40%" align=right>性别:</td>
    			  <td width="60%" align="left">&nbsp;<input id="update_sex" type="text" name="sex" style="width: 60%;left: 0px" value="<%=driver.getSex() %>"></td>  			 
  			</tr>
  			<tr height="40px">
    			<td width="40%" align=right>年龄:</td>
    			<td width="60%" align="left">&nbsp;<input id="update_age" type="text" name="age" style="width: 60%;left: 0px" value="<%=driver.getAge() %>"></td>
  			</tr>
  			<tr height="40px">
    			<td width="40%" align=right>车龄:</td>
    			<td width="60%" align="left">&nbsp;<input id="update_driverage" type="text" name="driverage" style="width: 60%;left: 0px" value="<%=driver.getDriverage() %>"></td>
  			</tr>
  			<tr height="40px">
    			<td width="40%" align=right>手机号:</td>
    			<td width="60%" align="left">&nbsp;<input id="update_phonenumber" type="text" name="phonenumber" style="width: 60%;left: 0px" value="<%=driver.getPhonenumber() %>"></td>
  			</tr>
  		</table>
  		<div align="center">
  		
			<input style="margin-left: auto;" type="submit" value="确定"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="清除"/>
		
		</div>
  		<br><br><br>
  	</div>
  	</form>
  </body>
</html>
