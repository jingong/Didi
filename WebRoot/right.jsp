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

<style type="text/css">
body,html,#allmap {
	width: 100%;
	height: 100%;
	overflow: hidden;
	margin: 0;
	font-family: "微软雅黑";
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=liuSPvyHqY1kUk3KbZf7U7HoCN5qSmdg"></script>
<title>地图展示</title>

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
	<div id="allmap" style="bottom:5px;height:100%;width:65%"></div>
	<div
		style="width: 30% bottom:5px;height:100%;position: absolute;top: 10px;right: 50px">
		<p align="center" style="font-size: large;">指挥司机</p>
		<br>
		<br>
		<form action="ReceieveOrderServlet" method="post">
			<table>
				<tr>
					<td>起始地： <input id="start" type="text" name="startpoint"
						style="width: 200px;height: 30px;font-size: large;"> <input
						style="width: 50px;height: 30px;font-size: large;" type="button"
						onclick="showMap()" value="定位" />
					</td>
				</tr>

				<tr>
					<td>司机名： <input id="name" type="text" name="username"
						style="width: 200px;height: 30px;font-size: large;" value="">
					</td>
				</tr>
				<tr>
					<td>目的地： <input id="end" type="text" name="endpoint"
						style="width: 200px;height: 30px;font-size: large;">
						<input
						style="width: 50px;height: 30px;font-size: large;" type="button"
						id="result" onclick="showRoute()" value="导航" />
					</td>
				</tr>
				<tr>
					<td>手机号： <input id="phone" type="text" name="phonenumber"
						style="width: 200px;height: 30px;font-size: large;">
					</td>
				</tr>
			</table>

			<input type="submit" value="去接客"
				style="width: 200px;height: 30px;font-size: large;position: absolute;left: 50px;" />
		</form>
	</div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(116.331398, 39.897445);
	map.centerAndZoom(point, 12);
	map.addControl(new BMap.NavigationControl());
	//添加比例尺控件
	map.addControl(new BMap.ScaleControl());
	// 创建地址解析器实例
	var myGeo = new BMap.Geocoder();
	// 将地址解析结果显示在地图上,并调整地图视野
	myGeo.getPoint("鲁东大学", function(point) {
		if (point) {
			map.centerAndZoom(point, 16);
			map.addOverlay(new BMap.Marker(point));
		} else {
			alert("您选择地址没有解析到结果!");
		}
	}, "烟台市");

	function showMap() {
		var start = document.getElementById("start").value;
		var pointArray = new Array();
		//创建地址解析器实例
		var myGeo = new BMap.Geocoder();
		myGeo.getPoint(start, function(point) {
			if (point) {
				map.centerAndZoom(point, 15);
				map.clearOverlays(); //清除地图上所有的标记(map.removeOverlay(marker)可清除单个标注)
				var marker = new BMap.Marker(point); //创建标注
				map.addOverlay(marker); //将标注添加到地图中
				var circle = new BMap.Circle(point, 1000, {
					fillColor : "blue",
					strokeWeight : 1,
					fillOpacity : 0.3,
					strokeOpacity : 0.3
				});
				map.addOverlay(circle);

			} else {
				alert("您的地址没有解析到结果!");
			}
		}, "烟台市");
	}
	function showRoute() {
		var start = document.getElementById("start").value;
	var end = document.getElementById("end").value;
	map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);
		//三种驾车策略：最少时间，最短距离，避开高速
		var routePolicy = [ BMAP_DRIVING_POLICY_LEAST_TIME,
				BMAP_DRIVING_POLICY_LEAST_DISTANCE,
				BMAP_DRIVING_POLICY_AVOID_HIGHWAYS ];
		//$("#result").click(function() {
			map.clearOverlays();
			var i = 0;
			search(start, end, routePolicy[i]);
			function search(start, end, route) {
				var driving = new BMap.DrivingRoute(map, {
					renderOptions : {
						map : map,
						autoViewport : true
					},
					policy : route
				});
				driving.search(start, end);
			}
		//});
	}
	
</script>
