package employee.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddEmployee {

    // Database connection parameters
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USERNAME = "employees";
    private static final String PASSWORD = "employees#123";

    public static void addEmployee(String firstName, String lastName, String email, String contactNumber)
            throws SQLException {
        // Validate input data
    	   if (!isValidName(firstName) || !isValidName(lastName) || !isValidEmail(email) || !isValidContactNumber(contactNumber)) {
               System.out.println("Invalid input data. Please check the provided information.");
               return;
           }
    	   
        // Generate unique Employee ID between e1 to e100
        String employeeId = generateUniqueEmployeeId();

        // Database connection and SQL query to insert employee
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO employee_records (employee_id, first_name, last_name, email, contact_number) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, employeeId);
                statement.setString(2, firstName);
                statement.setString(3, lastName);
                statement.setString(4, email);
                statement.setString(5, contactNumber);
                statement.executeUpdate();
                System.out.println("Employee added successfully!");
            }
        }
    }

    private static boolean isValidName(String name) {
        return name.matches("^[A-Za-z]+\\.?[A-Za-z]*$");
    }

    private static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.com$");
    }

    private static boolean isValidContactNumber(String contactNumber) {
        return contactNumber.matches("\\d{10}");
    }

    private static String generateUniqueEmployeeId() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT COUNT(*) FROM employee_records";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    if (count < 100) {
                        return "e" + (count + 1);
                    } else {
                        throw new SQLException("Maximum employee limit reached (100 employees).");
                    }
                }
            }
        }
        throw new SQLException("Failed to generate unique Employee ID.");
    }
}