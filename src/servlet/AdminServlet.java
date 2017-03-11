package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.MyConnection;
//管理员登录
public class AdminServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		Connection conn = MyConnection.getConnection();
		
		String name = request.getParameter("name").trim();
		String password = request.getParameter("password").trim();
		
		if (name==null || name.equals("") || password==null || password.equals("")) {
			PrintWriter out = response.getWriter();
			out.print("<script>alert('请完整填写用户名和密码！'); window.location='login.jsp' </script>");
			out.flush();
			out.close();
			return;
		}
		if (id.equals("0")) {//管理员验证
			String sql = "select * from admin where name ='" + name + "'" + " and password ='" + password + "'";
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					response.sendRedirect(path + "/main.jsp");
				}
				else {
					PrintWriter out = response.getWriter();
					out.print("<script>alert('登录失败，请检查用户名和密码！'); window.location='login.jsp' </script>");
					out.flush();
					out.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(id.equals("1")){//司机验证
			String sql = "select * from driver where username ='" + name + "'" + " and password ='" + password + "'";
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					HttpSession session=request.getSession();
					session.setAttribute("username", name);//保存起来当前登录的司机用户名
					response.sendRedirect(path + "/Driver/driver.jsp");
				}else {
					PrintWriter out = response.getWriter();
					out.print("<script>alert('登录失败，请检查用户名和密码！'); window.location='login.jsp' </script>");
					out.flush();
					out.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
}
