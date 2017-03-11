<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    <title>My JSP 'test.jsp' starting page</title>
    
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
    <div id="allmap" ></div>
    <input style="width: 50px;height: 30px;font-size: large;"
						type="button" onclick="" value="定位" />
  </body>
</html>
<script type="text/javascript">
  // 百度地图API功能
  var map = new BMap.Map("allmap");
  map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);
  // 添加带有定位的导航控件
  var navigationControl = new BMap.NavigationControl({
    // 靠左上角位置
    anchor: BMAP_ANCHOR_TOP_LEFT,
    // LARGE类型
    type: BMAP_NAVIGATION_CONTROL_LARGE,
    // 启用显示定位
    enableGeolocation: true
  });
  map.addControl(navigationControl);
  // 添加定位控件
  var geolocationControl = new BMap.GeolocationControl();
  geolocationControl.addEventListener("locationSuccess", function(e){
    // 定位成功事件
    var address = '';
    address += e.addressComponent.province;
    address += e.addressComponent.city;
    address += e.addressComponent.district;
    address += e.addressComponent.street;
    address += e.addressComponent.streetNumber;
    alert("当前定位地址为：" + address);
  });
  geolocationControl.addEventListener("locationError",function(e){
    // 定位失败事件
    alert(e.message);
  });
  map.addControl(geolocationControl);
  function showMap(){
		var start="烟台大学";
		var pointArray = new Array(); 
		  //创建地址解析器实例
		 var myGeo = new BMap.Geocoder();
		 myGeo.getPoint(start, function(point){
		 	if(point){
		 		map.centerAndZoom(point, 15);
		        map.clearOverlays();                 //清除地图上所有的标记(map.removeOverlay(marker)可清除单个标注)
		        var marker = new BMap.Marker(point); //创建标注
		        map.addOverlay(marker);              //将标注添加到地图中
		        var circle = new BMap.Circle(point,1000,{fillColor:"blue", strokeWeight: 1 ,fillOpacity: 0.3, strokeOpacity: 0.3});
                map.addOverlay(circle);
                
			    
	}
							 else {
								alert("您的地址没有解析到结果!");
							}
						}, "烟台市");
	}
</script>