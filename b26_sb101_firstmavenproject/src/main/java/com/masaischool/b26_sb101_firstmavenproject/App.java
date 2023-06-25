package com.masaischool.b26_sb101_firstmavenproject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class App {
	static String URL;
	static String username;
	static String password;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("dbdetails");
    	URL = bundle.getString("URL");
    	username = bundle.getString("USERNAME");
    	password = bundle.getString("PASSWORD");
	}
	
	static Connection createConnection() throws SQLException{
		return DriverManager.getConnection(URL, username, password);
	}
	
    public static void main( String[] args ){
    	Connection connection = null;
    	Savepoint setSavepoint = null;
    	try{
    		connection = createConnection();
    		System.out.println("Connection created");
    		//set the auto commit to false
    		connection.setAutoCommit(false);
    		System.out.println("auto commit is false");
    		//Create a String query
    		String query = "INSERT INTO employee VALUES (?, ?, ?, ?)";
    		
    		//Create an object of PreparedStatement
    		PreparedStatement prepareStatement = connection.prepareStatement(query);
    		
    		//set the value to parameters
    		prepareStatement.setString(1, "E008");
    		prepareStatement.setString(2, "IUY");
    		prepareStatement.setDouble(3, 11.25);
    		prepareStatement.setDate(4, Date.valueOf(LocalDate.now()));
    		
    		//call the executeUpdate
    		prepareStatement.executeUpdate();
    		System.out.println("insert query executed");
    		
    		setSavepoint = connection.setSavepoint("spOne");
    		
    		query = "UPDATE employee SET empName = ?, annualSalary = ?, joiningDate = ? WHERE empIds = ?";
    		//query = "UPDATE employee SET empName = ?, annualSalary = ?, joiningDate = ? WHERE empId = ?";
    		prepareStatement = connection.prepareStatement(query);
    		//set the value to parameters
    		prepareStatement.setString(1, "YUR");
    		prepareStatement.setDouble(2, 8.25);
    		prepareStatement.setDate(3, Date.valueOf(LocalDate.now().plusDays(1)));
    		prepareStatement.setString(4, "E007");
    		
    		//call the executeUpdate
    		prepareStatement.executeUpdate();
    		
    		//call the commit()
    		connection.commit();
    		System.out.println("commit is called");
    	}catch(SQLException ex) {
    		System.out.println(ex);
    		try {
        		connection.rollback(setSavepoint);    			
        		connection.commit();
        		System.out.println("rollback is called");
    		}catch(SQLException e) {
    			System.out.println(e);
    		}

    	}finally {
    		try {
				connection.close();
				System.out.println("Connection closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	System.out.println("Bye Bye");
    }
}
