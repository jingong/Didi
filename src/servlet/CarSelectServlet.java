package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.CarBiz;
import connection.MyConnection;
import entity.Car;

public class CarSelectServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getContextPath();
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String carnumber = req.getParameter("carnumber");
		Connection connection = MyConnection.getConnection();
		CarBiz cb = new CarBiz(connection);
		PrintWriter out = resp.getWriter();
		if (carnumber == null || carnumber.equals("")) {
			out.print("<script>alert('车牌号不能为空，请重新修改！'); window.location='car_select.jsp' </script>");
		}else if (cb.countWhere(carnumber) <= 0) {
			out.print("<script>alert('该车辆不存在，请重新输入！'); window.location='car_select.jsp' </script>");
		}else{
			Car car = cb.selectCar(carnumber);
			HttpSession session=req.getSession();
			session.setAttribute("car", car);
			resp.sendRedirect(path + "/carinfo.jsp");
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
