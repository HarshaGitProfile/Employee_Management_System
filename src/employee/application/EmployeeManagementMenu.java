package employee.application;
import java.sql.SQLException;
import java.util.Scanner;

import employee.operations.AddEmployee;
import employee.operations.DeleteEmployee;
import employee.operations.DisplayEmployee;
import employee.operations.EditEmployee;

public class EmployeeManagementMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Employee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Edit Employee Details");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter First Name: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Enter Last Name: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter Contact Number: ");
                        String contactNumber = scanner.nextLine();
                        AddEmployee.addEmployee(firstName, lastName, email, contactNumber);
                        break;
                    case 2:
                        DisplayEmployee.displayEmployees();
                        break;
                    case 3:
                    	 System.out.println("Select an option for editing:");
                         System.out.println("1. Edit by Employee ID");
                         System.out.println("2. Edit by Email ID");
                         System.out.print("Enter your choice: ");
                         int option = Integer.parseInt(scanner.nextLine());

                         if (option == 1) {
                             System.out.print("Enter Employee ID to edit: ");
                             String employeeIdToEdit = scanner.nextLine();
                             System.out.print("Enter New First Name: ");
                             String newFirstName = scanner.nextLine();
                             System.out.print("Enter New Last Name: ");
                             String newLastName = scanner.nextLine();
                             System.out.print("Enter New Email: ");
                             String newEmail = scanner.nextLine();
                             System.out.print("Enter New Contact Number: ");
                             String newContactNumber = scanner.nextLine();
                             EditEmployee.editEmployeeDetails(employeeIdToEdit, newFirstName, newLastName, newEmail, newContactNumber);
                         } else if (option == 2) {
                             System.out.print("Enter Email ID to edit: ");
                             String emailIdToEdit = scanner.nextLine();
                             System.out.print("Enter New First Name: ");
                             String newFirstName = scanner.nextLine();
                             System.out.print("Enter New Last Name: ");
                             String newLastName = scanner.nextLine();
                             System.out.print("Enter New Email: ");
                             String newEmail = scanner.nextLine();
                             System.out.print("Enter New Contact Number: ");
                             String newContactNumber = scanner.nextLine();
                             EditEmployee.editEmployeeDetails(emailIdToEdit, newFirstName, newLastName, newEmail, newContactNumber);
                         } else {
                             System.out.println("Invalid choice. Please select 1 or 2.");
                         }
                        break;
                    case 4:
                    	System.out.println("Select an option for editing:");
                        System.out.println("1. Delete by Employee ID");
                        System.out.println("2. Delete by Email ID");
                        System.out.print("Enter your choice: ");
                        int select = Integer.parseInt(scanner.nextLine());
                        if(select==1)
                        {
                        	System.out.print("Enter Employee ID to delete: ");
                            String employeeIdToDelete = scanner.nextLine();
                            DeleteEmployee.deleteEmployee(employeeIdToDelete);
                        } else if(select==2)
                        {
                        	System.out.print("Enter Employee Mail Id to delete: ");
                            String employeeMailIdToDelete = scanner.nextLine();
                            DeleteEmployee.deleteEmployee(employeeMailIdToDelete);
                        }else
                        {
                        	System.out.println("Invalid choice. Please select 1 or 2.");
                        }
                        break;
                    case 5:
                        System.out.println("Exiting the Employee Management System.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } catch (SQLException e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }
}