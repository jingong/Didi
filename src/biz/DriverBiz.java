package biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Driver;
import entity.DriverHistory;

public class DriverBiz {
	Connection connection;
	Statement statement;
	public DriverBiz(){
		
	}
	public DriverBiz(Connection connection){
		this.connection = connection;
	}
	public int insert(Driver driver){
		PreparedStatement pstm = null;
		int affect = 0;//0表示正常状态，-1表示失败，1表示成功
		String sql = "Insert into driver( " +
                "username,password,name,sex,age,driverage,phonenumber"+
         " ) values ( "+
                "?, ?, ?, ?,?,?,?)";
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, driver.getUsername());
			pstm.setString(2, driver.getPassword());
			pstm.setString(3, driver.getName());
			pstm.setString(4, driver.getSex());
			pstm.setInt(5, driver.getAge());
			pstm.setInt(6, driver.getDriverage());
			pstm.setString(7,driver.getPhonenumber());
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
	public int countWhere(String username){
		ResultSet rs = null;
		int count = 0;
		String sql = "SELECT COUNT(1) CT  FROM driver WHERE username ='"+username+"'";
		try {
			statement = connection.createStatement();
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
	public Driver selectDriver(String username){
		ResultSet rs = null;
		Driver driver = new Driver();
		String sql = "SELECT * FROM driver WHERE username ='"+username+"'";
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			if (rs.next()) {
				driver.setUsername(rs.getString("username"));
				driver.setName(rs.getString("name"));
				driver.setSex(rs.getString("sex"));
				driver.setAge(Integer.parseInt(rs.getString("age")));
				driver.setDriverage(Integer.parseInt(rs.getString("driverage")));
				driver.setPhonenumber(rs.getString("phonenumber"));
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
		return driver;
	}
	public int update(String username,String name,String sex,int age,int driverage,String phonenumber){
		PreparedStatement pstmt = null;
		int affect = 0;
		try{
			String sql ="UPDATE driver" +
					" SET name=?,sex=?,age=?,driverage=?,phonenumber=?" +
			        " WHERE username=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, "f");
			pstmt.setInt(3, age);
			pstmt.setInt(4, driverage);
			pstmt.setString(5, "123456");
			pstmt.setString(6, username);
			affect = pstmt.executeUpdate();
		}catch(SQLException e){
			affect = -1;
			e.printStackTrace();
		}
		finally{
			try {
				if(pstmt!=null){
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return affect;
	}
	public int deleteDriver(String username){
		String sql = "DELETE FROM driver WHERE username='" + username + "'";
		int affect = 0;
		try {
			statement = connection.createStatement();
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			affect = -1;
			e.printStackTrace();
		}finally{
			try {
				if(statement!=null){
					statement.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return affect;
	}
	public int insertHistory(DriverHistory history){
		int affect = 0;
		PreparedStatement pstm = null;
		String sql = "Insert into driverhistory( " +
                "username,startpoint,endpoint,phonenumber,date"+
         " ) values ( "+
                "?,?,?,?,?)";
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, history.getUsername());
			pstm.setString(2, history.getStartpoint());
			pstm.setString(3, history.getEndpoint());
			pstm.setString(4, history.getPhonenumber());
			pstm.setString(5, history.getDate());
			//pstm.setInt(6, 0);
			affect = pstm.executeUpdate();
		} catch (SQLException e) {
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
}
