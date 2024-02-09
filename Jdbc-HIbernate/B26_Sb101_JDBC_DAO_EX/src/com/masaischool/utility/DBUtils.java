package com.masaischool.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
	static String URL;
	static String username;
	static String password;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("dbdetails");
		URL = bundle.getString("URL");
		username = bundle.getString("USERNAME");
		password = bundle.getString("PASSWORD");
	}
	
	public static Connection createConnection() throws SQLException {
		return DriverManager.getConnection(URL, username, password);
	}
	
	public static boolean isResultSetEmpty(ResultSet resultSet) throws SQLException{
		return (!resultSet.isBeforeFirst() && resultSet.getRow() == 0);
	}
}
