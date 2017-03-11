<%@page import="entity.Car"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>车辆信息</title>
    
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
    	Car car = (Car)session.getAttribute("car");
    	if(car == null){
    		response.sendRedirect(path+"/car_select.jsp");
    	}
     %>
     <form action="" method="post">
  	<div style="width:80%;margin-left:10%;margin-right:10%">
  		<br><br><br>
  		<p align="center">车辆信息如下：</p>
  		<table width="60%" border="0" cellpadding="0" cellspacing="0" style="margin-left:20%;margin-right:20%">
  			<tr height="40px">
    			<td width="40%" align=right>车牌号:</td>
    			<td width="60%" align="left">&nbsp;<input id="carnumber" disabled="true" type="text" name="carnumber" style="width: 60%;left: 0px" value="<%=car.getCarNumber() %>"></td>
  			</tr>
  			<tr height="40px">
    			<td width="40%" align=right>车辆型号:</td>
    			<td width="60%" align="left">&nbsp;<input id="cartype" disabled="true" type="text" name="cartype" style="width: 60%;left: 0px" value="<%=car.getCarType() %>"></td>
  			</tr>
  			<tr height="40px">
    			<td width="40%" align=right>车辆制造公司:</td>
    			  <td width="60%" align="left">&nbsp;<input id="carcompany" disabled="true" type="text" name="carcompany" style="width: 60%;left: 0px" value="<%=car.getCarCompany() %>"></td>  			 
  			</tr>
  			<tr height="40px">
    			<td width="40%" align=right>车辆购买时间:</td>
    			<td width="60%" align="left">&nbsp;<input id="carpurchase" disabled="true" type="text" name="carpurchase" style="width: 60%;left: 0px" value="<%=car.getCarPurchase() %>"></td>
  			</tr>
  			<tr height="40px">
    			<td width="40%" align=right>车辆使用时间:</td>
    			<td width="60%" align="left">&nbsp;<input id="carusetime" disabled="true" type="text" name="carusetime" style="width: 60%;left: 0px" value="<%=car.getCarUsetime() %>"></td>
  			</tr>
  		</table>
  		<br>
  		<br><br><br>
  	</div>
  	</form>
  </body>
</html>
