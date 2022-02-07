package util;

import java.sql.Connection;
import java.sql.DriverManager;

import Interface.ConnectionInterface;
import net.java.registration.model.Employee;

public class DatabaseConnection {

	public static Connection createConnection() {
		Connection connection = null;
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "Pranav@1920@";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}