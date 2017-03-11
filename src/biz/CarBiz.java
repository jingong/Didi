package biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Car;

public class CarBiz {
	private Connection connection =null;
	private Statement statement =null; 
	public CarBiz() {
	}
	public CarBiz(Connection connection){
		this.connection = connection;
	}
	public int insert(Car car){
		PreparedStatement pstm = null;
		int affect = 0;//0表示正常状态，-1表示失败，1表示成功
		String sql = "Insert into car( " +
                "carnumber,cartype,carcompany,carpurchase,carusetime"+
         " ) values ( "+
                "?, ?, ?, ?,?)";
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, car.getCarNumber());
			pstm.setString(2, car.getCarType());
			pstm.setString(3, car.getCarCompany());
			pstm.setString(4, car.getCarPurchase());
			pstm.setInt(5, car.getCarUsetime());
			affect = pstm.executeUpdate();
		} catch (Exception e) {
			affect = -1;
			e.printStackTrace();
		}finally{
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return affect;
	}
	public int countWhere(String carnumber){
		ResultSet rs = null;
		int count = 0;
		String sql = "SELECT COUNT(1) CT  FROM car WHERE carnumber ='"+carnumber+"'";
		try {
			statement = (Statement) connection.createStatement();
			rs = statement.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt("CT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	public Car selectCar(String carnumber){
		ResultSet rs = null;
		Car car = null;
		String sql = "SELECT * FROM car WHERE carnumber ='"+carnumber+"'";
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			car = new Car();
			if (rs.next()) {
				car.setCarNumber(rs.getString("carnumber"));
				car.setCarType(rs.getString("cartype"));
				car.setCarCompany(rs.getString("carcompany"));;
				car.setCarPurchase(rs.getString("carpurchase"));;
				car.setCarUsetime(rs.getInt("carusetime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return car;
	}
}
