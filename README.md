# Employee Management System

This Java application, developed using Eclipse IDE and Oracle JDBC, allows you to efficiently manage employee records. It provides options to add, display, edit, and delete employees from the system while ensuring data integrity through validation and exception handling.

## Prerequisites

- **Java Development Kit (JDK):** Ensure you have JDK installed on your system. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

- **Oracle Database:** Set up an Oracle Database and note down the connection details (URL, username, and password) for JDBC connectivity.

- **Eclipse IDE:** Download and install Eclipse IDE from [the official Eclipse website](https://www.eclipse.org/downloads/).

- **Oracle JDBC Driver:** Download the Oracle JDBC driver (ojdbc11.jar) from [Oracle's official website](https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html) and add it to your Eclipse project's build path.

## Setup and Configuration

1. **Clone the Repository:**
   
   ```bash
   git clone https://github.com/your-username/employee-management-system.git
   ```

2. **Open Eclipse IDE:**
   
   Launch Eclipse and import the cloned project into your workspace.

3. **Configure Database Connection:**

   Open the `DatabaseConnection.java` file and update the following variables with your Oracle Database connection details:

   ```java
   private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
   private static final String USERNAME = "your-username";
   private static final String PASSWORD = "your-password";
   ```

4. **Compile and Run:**

   Compile and run the `Main.java` file in Eclipse to start the Employee Management System application.

## Usage

Upon running the application, a menu will be displayed with the following options:

1. **Add Employee:** Enter employee details as prompted. The system will validate the input and add the employee.

2. **Display All Employees:** View all existing employee records.

3. **Edit Employee Details:** Edit employee information based on Employee ID or Email Address.

4. **Delete Employee Record:** Delete an employee based on Employee ID or Email Address.

## Employee Details Validation Rules

1. **First Name:** Should not contain numbers or special characters except for a dot(.).

2. **Last Name:** Should not contain numbers or special characters except for a dot(.).

3. **Employee ID:** Unique and randomly generated between e1 to e100.

4. **Email Address:** Must include "@" symbol and end with ".com".

5. **Contact Number:** Must be exactly 10 digits and not contain alphabets or special characters.

## Exception Handling

The application implements proper exception handling using try/except blocks to handle potential errors such as:

- Duplicate Employee IDs.
- Incorrect data entry for First Name, Last Name, Email Address, and Contact Number.
