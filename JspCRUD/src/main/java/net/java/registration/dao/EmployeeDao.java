package net.java.registration.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import net.java.registration.model.Employee;
import util.DatabaseConnection;

public class EmployeeDao {

	public void registerEmployee(Employee employee) throws Exception  {
		
		Connection connection;
		PreparedStatement preparedStatement = null;
		try {
			connection = DatabaseConnection.createConnection();
			try {
				String insertQuery = "INSERT INTO employee" 
				+ " (first_name, last_name, username, password, address, contact) VALUES " 
				+ " (?, ?, ?, ?, ?, ?);";
				preparedStatement = connection.prepareStatement(insertQuery);
				preparedStatement.setString(1, employee.getFirstName());
				preparedStatement.setString(2, employee.getLastName());
				preparedStatement.setString(3, employee.getUsername());
				preparedStatement.setString(4, employee.getPassword());
				preparedStatement.setString(5, employee.getAddress());
				preparedStatement.setString(6, employee.getContact());
				preparedStatement.executeUpdate(); // Execute the query or update query
			} catch (Exception e) { // Process exception
				System.out.print(e);
			}
		} catch (Exception e) { // Process exception
			System.out.print(e);
		}
	}

}