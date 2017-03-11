package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.DriverBiz;
import connection.MyConnection;
import entity.DriverHistory;

public class ReceieveOrderServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getContextPath();
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String startpoint = req.getParameter("startpoint");
		String endpoint = req.getParameter("endpoint");
		String phonenumber = req.getParameter("phonenumber");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间
		Connection condition = MyConnection.getConnection();
		PrintWriter out = resp.getWriter();
		int affect = 0;
		int count;
		DriverBiz db = new DriverBiz(condition);
		if (username == null || username.equals("")) {
			out.print("<script>alert('司机姓名为空，请重新输入！'); window.location='right.jsp' </script>");
		}else if (db.countWhere(username) <= 0) {
			out.print("<script>alert('该司机不存在，请重新输入！'); window.location='right.jsp' </script>");
		}else if (startpoint.equals("") || startpoint == null || endpoint.equals("") || endpoint == null) {
			out.print("<script>alert('地点输入有误，请重新输入！'); window.location='right.jsp' </script>");
		}else if (phonenumber == null || phonenumber.equals("")) {
			out.print("<script>alert('手机号码有误，请重新输入！'); window.location='right.jsp' </script>");
		}else{
			DriverHistory history = new DriverHistory(username,startpoint,endpoint,phonenumber,date);
			affect = db.insertHistory(history);
			if (affect > 0) {
				out.print("<script>alert('订单已下发！'); window.location='right.jsp' </script>");
			}else {
				out.print("<script>alert('订单下发失败！'); window.location='right.jsp' </script>");
			}
		}
		out.flush();
		out.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
