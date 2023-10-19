package employee.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditEmployee {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USERNAME = "employees";
    private static final String PASSWORD = "employees#123";

    public static void editEmployeeDetails(String employeeIdOrEmail, String newFirstName, String newLastName, String newEmail, String newContactNumber) {
        String sql = "UPDATE employee_records SET first_name = ?, last_name = ?, email = ?, contact_number = ? WHERE employee_id = ? OR email = ?";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newFirstName);
            statement.setString(2, newLastName);
            statement.setString(3, newEmail);
            statement.setString(4, newContactNumber);
            statement.setString(5, employeeIdOrEmail);
            statement.setString(6, employeeIdOrEmail);
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee details updated successfully!");
            } else {
                System.out.println("No employee found with the given ID or Email.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}