package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.DriverBiz;
import connection.MyConnection;

public class DriverCancelServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getContextPath();
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		Connection connection = MyConnection.getConnection();
		DriverBiz db = new DriverBiz(connection);
		PrintWriter out = resp.getWriter();
		int count;
		count = db.countWhere(username);
		if(count > 0){
			int affect = db.deleteDriver(username);
			if (affect > 0) {
				out.print("<script>alert('司机注销成功！'); window.location='driver_cancel.jsp' </script>");
			}else {
				out.print("<script>alert('注销失败，请重新注销！'); window.location='driver_cancel.jsp' </script>");
			}
		}else {			
			out.print("<script>alert('该司机不存在，请重新输入！'); window.location='driver_cancel.jsp' </script>");
		}
		out.flush();
		out.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
