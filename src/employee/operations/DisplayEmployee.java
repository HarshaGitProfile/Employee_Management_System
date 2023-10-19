package employee.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayEmployee {
	 public static void displayEmployees() throws SQLException {
	        // Database connection parameters
	        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	        String username = "employees";
	        String password = "employees#123";

	        // JDBC connection and SQL query to display employees
	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	            String sql = "SELECT * FROM employee_records";
	            try (Statement statement = connection.createStatement();
	                    ResultSet resultSet = statement.executeQuery(sql)) {
	                while (resultSet.next()) {
	                    System.out.println("First Name: " + resultSet.getString("first_name"));
	                    System.out.println("Last Name: " + resultSet.getString("last_name"));
	                    System.out.println("Employee ID: " + resultSet.getString("employee_id"));
	                    System.out.println("Email: " + resultSet.getString("email"));
	                    System.out.println("Contact Number: " + resultSet.getString("contact_number"));
	                    System.out.println("-------------------------");
	                }
	            }
	        }
	    }
}
