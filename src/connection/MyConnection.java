package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/didi?useUnicode=true&characterEncoding=gbk";
			String user = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("数据库连接部分发生错误！");
		}
		return conn;		
	}
}
