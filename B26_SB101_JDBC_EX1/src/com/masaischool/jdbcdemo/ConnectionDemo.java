package com.masaischool.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionDemo {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		}catch(ClassNotFoundException ex) {
			System.out.println("Minimum requirement not matched");
			System.exit(1);
		}
	}
	
	static Connection createConnection() {
		String URL = "jdbc:mysql://localhost/B26_SB101_JDBC_EX1";
		String username = "root";
		String password = "root";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, username, password);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return connection;
	}
	
	static void closeConnect(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			}catch(SQLException ex) {
				System.out.println(ex);
			}
		}
	}
	
	static void insertEmployee(Scanner sc) {
		System.out.print("Enter employee Id ");
		String empId = sc.next();	//E001
		System.out.print("Enter employee name ");
		String empName = sc.next();	//BCD
		System.out.print("Enter annual salary ");
		double annualSalary = sc.nextDouble();	//20.25
		System.out.print("Enter joining date (YYYY-MM-DD) ");
		String joiningDate = sc.next();	//2023-01-10
		
		//Create Query
		//Do not use static queries because they are slow in performance for user data
		//String insertStatement = "INSERT INTO employee VALUES('" + empId + "', '" + empName +"', " + annualSalary + ", '" + joiningDate + "')";
		
		//? is placeholder the value
		String insertStatement = "INSERT INTO employee VALUES(?, ?, ?, ?)";
		//get database connection
		Connection connection = createConnection();
		try {
			//Create a preparedStatement
			PreparedStatement prepareStatement = connection.prepareStatement(insertStatement);

			//providing value to the placeholders
			prepareStatement.setString(1, empId);			
			prepareStatement.setString(2, empName);
			prepareStatement.setDouble(3, annualSalary);
			prepareStatement.setString(4, joiningDate);
			
			//execute the query
			if(prepareStatement.executeUpdate() > 0) {
				System.out.println("Employee added successfully");
			}else {
				System.out.println("unable to add employee");
			}
			
			closeConnect(connection);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
	}
	
	static void viewEmployees() {
		//get database connection
		Connection connection = createConnection();
		
		//Create Query
		String selectQuery = "SELECT * FROM employee";
		
		try {
			//Create a preparedStatement
			PreparedStatement prepareStatement = connection.prepareStatement(selectQuery);
			ResultSet resultSet = prepareStatement.executeQuery();
			//Initially the cursor is positioned before the first row.
			//The next method moves the cursor to the next row
			//if next row is not available then next() method will return false
			if(!resultSet.next()) {
				System.out.println("no Employee found");
			}else {
				//you are here means the result set is on first row
				do {
					System.out.print("EmpId " + resultSet.getString(1));
					System.out.print(" Emp Name " + resultSet.getString(2));
					System.out.print(" Annual Salary " + resultSet.getDouble(3));
					System.out.print(" Joining Date" + resultSet.getDate(4) + "\n");
				}while(resultSet.next());
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
		//close the database connection
		closeConnect(connection);
	}
	
	static void updateEmployee(Scanner sc) {
		System.out.print("Enter employee Id ");
		String empId = sc.next();	//E001
		System.out.print("Enter employee name ");
		String empName = sc.next();	//BCD
		System.out.print("Enter annual salary ");
		double annualSalary = sc.nextDouble();	//20.25
		System.out.print("Enter joining date (YYYY-MM-DD) ");
		String joiningDate = sc.next();	//2023-01-10

		//? is placeholder the value
		String updateStatement = "UPDATE employee SET empName =?, annualSalary = ?, joiningDate = ? WHERE empid = ?";
				
		//get database connection
		Connection connection = createConnection();
		
		try {
			//Create a preparedStatement
			PreparedStatement prepareStatement = connection.prepareStatement(updateStatement);

			//providing value to the placeholders
			prepareStatement.setString(1, empName);
			prepareStatement.setDouble(2, annualSalary);
			prepareStatement.setString(3, joiningDate);
			prepareStatement.setString(4, empId);
			
			//execute the query
			if(prepareStatement.executeUpdate() > 0) {
				System.out.println("Employee updated successfully");
			}else {
				System.out.println("unable to updated employee");
			}
			
			closeConnect(connection);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
		closeConnect(connection);
	}
	
	static void deleteEmployee(Scanner sc) {
		System.out.print("Enter employee Id ");
		String empId = sc.next();	//E001

		//? is placeholder the value
		String deleteStatement = "DELETE FROM employee WHERE empid = ?";
				
		//get database connection
		Connection connection = createConnection();
		
		try {
			//Create a preparedStatement
			PreparedStatement prepareStatement = connection.prepareStatement(deleteStatement);

			//providing value to the placeholders
			prepareStatement.setString(1, empId);
			
			//execute the query
			if(prepareStatement.executeUpdate() > 0) {
				System.out.println("Employee deleted successfully");
			}else {
				System.out.println("unable to delete employee");
			}
			
			closeConnect(connection);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
		closeConnect(connection);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("1. Insert Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("0. Exit");
			System.out.print("Enter Selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					insertEmployee(sc);
					break;
				case 2:
					viewEmployees();
					break;
				case 3:
					updateEmployee(sc);
					break;
				case 4:
					deleteEmployee(sc);
					break;
				case 0:
					System.out.println("Thanks for using our services");
					break;
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(choice != 0);
		sc.close();
	}
}

