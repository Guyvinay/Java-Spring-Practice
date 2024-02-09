package com.masaischool.dao;

import java.util.List;

import com.masaischool.dto.Employee;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public interface IEmployeeDAO {
	void addEmployee(Employee employee) throws SomethingWentWrongException;
	List<Employee> getEmployeeList() throws SomethingWentWrongException, NoRecordFoundException;
	void updateEmployee(Employee employee) throws SomethingWentWrongException;
	void deleteEmployee(String empId) throws SomethingWentWrongException;
}
