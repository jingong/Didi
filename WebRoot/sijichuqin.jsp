<%@page import="connection.MyConnection"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>司机出勤情况</title>
</head>
<body>
	<center>
		司机出勤情况
		<hr>
		<table border="1" bgcolor="cccfff" align="center">
			<tr>
				<th width="150px">用户名</th>
				<th width="150px">起始地</th>
				<th width="150px">目的地</th>
				<th width="150px">手机号</th>
				<th width="150px">时间</th>
			</tr>
			<%
				Connection conn = MyConnection.getConnection();
				int intPageSize; //一页显示的记录数
				int intRowCount; //记录总数
				int intPageCount; //总页数
				int intPage; //待显示页码
				String strPage;
				int i;
				intPageSize = 3; //设置一页显示的记录数
				strPage = request.getParameter("page"); //取得待显示页码
				if (strPage == null) {
					/*表明在QueryString中没有page这一个参数，此时显示第一页数据*/
					intPage = 1;
				} else {
					//将字符串转换成整型
					intPage = java.lang.Integer.parseInt(strPage);
					if (intPage < 1)
						intPage = 1;
				}
				Statement stmt = conn
						.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
				String sql = "select * from driverhistory";
				ResultSet rs = stmt.executeQuery(sql);
				rs.last(); //光标指向查询结果集中最后一条记录	
				intRowCount = rs.getRow(); //获取记录总数
				//记算总页数
				intPageCount = (intRowCount + intPageSize - 1) / intPageSize;
				if (intPage > intPageCount)
					//调整待显示的页码
					intPage = intPageCount;
				if (intPageCount > 0) {
					rs.absolute((intPage - 1) * intPageSize + 1);
					//将记录指针定位到待显示页的第一条记录上
					//显示数据
					i = 0;
					%>
					<p align="center">当前是第<%=intPage %>页</p>
					<%
					while (i < intPageSize && !rs.isAfterLast()) {
			%>
			<tr>
				<td><%=rs.getString("username")%></td>
				<td><%=rs.getString("startpoint")%></td>
				<td><%=rs.getString("endpoint")%></td>
				<td><%=rs.getString("phonenumber")%></td>
				<td><%=rs.getString("date")%></td>
			</tr>
			<%
				rs.next();
						i++;
					}
				}
			%>
		</table>
		<hr>
		<div align="center">
			<a href="sijichuqin.jsp?page=1">首页</a>
			<%
			if (intPage > 1) {%>
				<a href="sijichuqin.jsp?page=<%=intPage - 1%>">上一页</a>	
			<%} if(intPage < intPageCount){%>
			<a href="sijichuqin.jsp?page=<%=intPage + 1%>">下一页</a>
			<%}%>
			<a href="sijichuqin.jsp?page=<%=intPageCount%>">最后一页</a>
			<%
				rs.close();
				stmt.close();
				conn.close();
			%>
		</div>
	</center>
</body>
</html>
