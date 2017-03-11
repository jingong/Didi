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

public class UpdateDriverServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getContextPath();
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String age = req.getParameter("age");
		String driverage = req.getParameter("driverage");
		String phonenumber = req.getParameter("phonenumber");
		System.out.println("username="+username);
		System.out.println("sex="+sex);
		System.out.println("name="+name);
		System.out.println("age="+age);
		System.out.println("driverage="+driverage);
		System.out.println("phonenumber="+phonenumber);
		int dage = 0;
		int dda = 0;
		try {
			dage = Integer.parseInt(age);
			dda = Integer.parseInt(driverage);
		} catch (Exception e) {
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('您的输入有误，请重新修改！'); window.location='sijixinxiupdate.jsp' </script>");
			out.flush();
			out.close();
		}
		Connection connection = MyConnection.getConnection();
		DriverBiz db = new DriverBiz(connection);
		int affect = db.update(username, name, sex, dage, dda, phonenumber);
		System.out.println(affect);
		PrintWriter out = resp.getWriter();
		out.print("<script>alert('司机信息修改成功！'); window.location='sijixinxiupdate.jsp' </script>");
		out.flush();
		out.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
