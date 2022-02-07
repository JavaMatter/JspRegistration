package Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.java.registration.model.Employee;
import util.DatabaseConnection;

public class EmpDaoImp implements ConnectionInterface {
	
	static Connection connection;
	static PreparedStatement ps;
	
	@Override
	public Employee getEmployee(String username, String password) {
		Employee employee = new Employee();
		try {
			connection = DatabaseConnection.createConnection();
			ps = connection.prepareStatement("select * from employee where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employee.setFirstName(rs.getString(1));
				employee.setLastName(rs.getString(2));
				employee.setUsername(rs.getString(3));
				employee.setPassword(rs.getString(4));
				employee.setAddress(rs.getString(5));
				employee.setContact(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}
		return employee;
	}

}
