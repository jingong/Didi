package servletdriver;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.DriverBiz;
import connection.MyConnection;
import entity.Driver;

public class DriverRegister extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getContextPath();
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String password1 = req.getParameter("password1");
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String age = req.getParameter("age").toString();
		
		System.out.println(age);
		String driverage = req.getParameter("driverage");
		String phonenumber = req.getParameter("phonenumber");
		if (password.equals(password1)) {
			Connection conn = MyConnection.getConnection();
			int dage = 0;
			int ddage = 0;
			PrintWriter out = resp.getWriter();
			try {
				dage = Integer.parseInt(age);
				ddage = Integer.parseInt(driverage);
			} catch (Exception e) {
				out.print("<script>alert('信息有误，请重新注册！'); window.location='Driver/dright.jsp' </script>");
				return;
			}
			Driver driver = new Driver(username,password,name,sex,dage,ddage,phonenumber);
			DriverBiz db = new DriverBiz(conn);
			int affect = db.insert(driver);
			req.setAttribute("flag", affect+"");
			if (affect == 1) {
				out.print("<script>alert('注册成功！'); window.location='Driver/dright.jsp' </script>");
			}else if (affect == -1) {
				out.print("<script>alert('注册失败，请重新注册！'); window.location='Driver/dright.jsp' </script>");
			}
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
