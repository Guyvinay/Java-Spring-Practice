package com.masaischool.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.dto.Employee;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.utility.DBUtils;

public class EmployeeDAOImpl implements IEmployeeDAO {
	@Override
	public void addEmployee(Employee employee) throws SomethingWentWrongException {
		try(Connection connection = DBUtils.createConnection()){
			//Create Query
			String insertQuery = "INSERT INTO employee VALUES (?, ?, ?, ?)";
			//get a PreparedStatement
			PreparedStatement ps = connection.prepareStatement(insertQuery);
			//stuff the data
			ps.setString(1, employee.getEmpId());
			ps.setString(2, employee.getEmpName());
			ps.setDouble(3, employee.getAnnualSalary());
			ps.setDate(4, Date.valueOf(employee.getJoiningDate()));
			//execute the query
			ps.executeUpdate();
		}catch(SQLException ex) {
			//log the exception information here for debugging purpose
			throw new SomethingWentWrongException("Unable to add Employee");
		}
	}
	
	@Override
	public List<Employee> getEmployeeList() throws SomethingWentWrongException, NoRecordFoundException{
		List<Employee> employeeList = null;
		try(Connection connection = DBUtils.createConnection()){
			//Create Query
			String selectQuery = "SELECT * FROM employee";
			//get a PreparedStatement
			PreparedStatement ps = connection.prepareStatement(selectQuery);
			//execute the query
			ResultSet resultSet = ps.executeQuery();
			//check if the resultSet empty
			if(DBUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("No Employee FOund");
			}
			//you are here means no exception
			employeeList = new ArrayList<>();
			while(resultSet.next()) {
				Employee emp = new Employee(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3), 
						resultSet.getDate(4).toLocalDate());
				employeeList.add(emp);
			}
			
		}catch(SQLException ex) {
			//log the exception information here for debugging purpose
			throw new SomethingWentWrongException("Unable to add Employee");
		}
		return employeeList;
	}
	
	@Override
	public void updateEmployee(Employee employee) throws SomethingWentWrongException{
		try(Connection connection = DBUtils.createConnection()){
			//Create Query
			String updateQuery = "UPDATE employee SET empName = ?, annualSalary = ?, joiningDate =  ? WHERE empId = ?";
			//get a PreparedStatement
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			//stuff the data
			ps.setString(1, employee.getEmpName());
			ps.setDouble(2, employee.getAnnualSalary());
			ps.setDate(3, Date.valueOf(employee.getJoiningDate()));
			ps.setString(4, employee.getEmpId());
			//execute the query
			ps.executeUpdate();
		}catch(SQLException ex) {
			//log the exception information here for debugging purpose
			throw new SomethingWentWrongException("Unable to update Employee");
		}
	}
	
	@Override
	public void deleteEmployee(String empId) throws SomethingWentWrongException{
		try(Connection connection = DBUtils.createConnection()){
			//Create Query
			String deleteQuery = "DELETE FROM employee WHERE empId = ?";
			//get a PreparedStatement
			PreparedStatement ps = connection.prepareStatement(deleteQuery);
			//stuff the data
			ps.setString(1, empId);
			//execute the query
			ps.executeUpdate();
		}catch(SQLException ex) {
			//log the exception information here for debugging purpose
			throw new SomethingWentWrongException("Unable to delete Employee");
		}
	}

}
