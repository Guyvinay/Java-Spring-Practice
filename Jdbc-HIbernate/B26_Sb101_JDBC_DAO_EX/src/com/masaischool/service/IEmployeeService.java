package com.masaischool.service;

import java.util.List;

import com.masaischool.dto.Employee;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public interface IEmployeeService {
	void addEmployee(Employee employee) throws SomethingWentWrongException;
	List<Employee> getEmployeeList() throws SomethingWentWrongException, NoRecordFoundException;
	void updateEmployee(Employee employee) throws SomethingWentWrongException;
	void deleteEmployee(String empId) throws SomethingWentWrongException;
	List<Employee> getEmployeeListByEmpIdDESC(List<Employee> employeeList);
	List<Employee> getEmployeeListByEmpNameASC(List<Employee> employeeList);
	List<Employee> getEmployeeListByJoiningDateASC(List<Employee> employeeList);
}
