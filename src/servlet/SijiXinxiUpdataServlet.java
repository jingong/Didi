package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.DriverBiz;
import connection.MyConnection;
import entity.Driver;

public class SijiXinxiUpdataServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getContextPath();
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		Connection connection = MyConnection.getConnection();
		DriverBiz db = new DriverBiz(connection);
		int count;
		if (username!=null && username.length() > 0) {
			count =db.countWhere(username);
			if (count > 0) {
				Driver driver = db.selectDriver(username);
				HttpSession session=req.getSession();
				session.setAttribute("driver", driver);
				resp.sendRedirect(path + "/updatedriver.jsp");
			}else {
				PrintWriter out = resp.getWriter();
				out.print("<script>alert('该司机不存在，请重新输入！'); window.location='sijixinxiupdate.jsp' </script>");
				out.flush();
				out.close();
			}
			
			
		}else {
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('您的输入有误，请重新输入！'); window.location='sijixinxiupdate.jsp' </script>");
			out.flush();
			out.close();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
