package util;

import java.sql.DriverManager;
import java.sql.Connection;

public class Databaseuser {
	public static Connection getConnection() {
		try {

			String driverName = "com.mysql.jdbc.Driver";
			String dbURL = "jdbc:mysql://119.70.168.9:1234/CHICKENREVIEW?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8";
			Class.forName(driverName);
			return DriverManager.getConnection(dbURL,"hello","1234");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
