package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.CarBiz;
import connection.MyConnection;
import entity.Car;

public class CarRegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getContextPath(); 
		resp.setContentType("text/html;charset=utf-8");  
		req.setCharacterEncoding("utf-8");
		String carnumber = req.getParameter("carnumber");
		String cartype = req.getParameter("cartype");
		String carcompany = req.getParameter("carcompany");
		String carpurchase = req.getParameter("carpurchase");
		String carusetime = req.getParameter("carusetime");
		Connection connection = MyConnection.getConnection();
		CarBiz cb = new CarBiz(connection);
		int ctime;
		PrintWriter out = resp.getWriter();
		try {
			ctime = Integer.parseInt(carusetime);
		} catch (Exception e) {
			out.print("<script>alert('信息有误，请重新注册！'); window.location='car_register.jsp' </script>");
			return;
		}
		Car car = new Car(carnumber,cartype,carcompany,carpurchase,ctime);
		int affect = cb.insert(car);
		if (affect == 1) {
			out.print("<script>alert('车辆注册成功！'); window.location='car_register.jsp' </script>");
		}else if (affect == -1) {
			out.print("<script>alert('注册失败，请重新注册！'); window.location='car_register.jsp' </script>");
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
