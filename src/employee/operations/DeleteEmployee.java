package employee.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee {
	 public static void deleteEmployee(String employeeIdOrEmail) throws SQLException {
	        // Database connection parameters
	        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	        String username = "employees";
	        String password = "employees#123";

	        // JDBC connection and SQL query to delete employee
	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	            String sql = "DELETE FROM employee_records WHERE employee_id = ? OR email=?";
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                statement.setString(1, employeeIdOrEmail);
	                statement.setString(2, employeeIdOrEmail);
	                int rowsDeleted = statement.executeUpdate();
	                if (rowsDeleted > 0) {
	                    System.out.println("Employee deleted successfully!");
	                } else {
	                    System.out.println("Employee not found with given employee ID/mail.");
	                }
	            }
	        }
	    }
}