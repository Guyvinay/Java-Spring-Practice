package com.masaischool.service;

import java.util.List;

import javax.swing.border.EtchedBorder;

import com.masaischool.dao.EmployeeDAOImpl;
import com.masaischool.dao.IEmployeeDAO;
import com.masaischool.dto.Employee;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public class EmployeeServiceImpl implements IEmployeeService {

	@Override
	public void addEmployee(Employee employee) throws SomethingWentWrongException {
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.addEmployee(employee);
	}
	
	@Override
	public void updateEmployee(Employee employee) throws SomethingWentWrongException{
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.updateEmployee(employee);
	}
	
	@Override
	public void deleteEmployee(String empId) throws SomethingWentWrongException{
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.deleteEmployee(empId);
	}
	
	@Override
	public List<Employee> getEmployeeList() throws SomethingWentWrongException, NoRecordFoundException{
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		return employeeDAO.getEmployeeList();
	}
	
	@Override
	public List<Employee> getEmployeeListByEmpIdDESC(List<Employee> employeeList){
		return employeeList.stream().sorted((e1, e2) -> e2.getEmpId().compareTo(e1.getEmpId())).toList();
	}
	
	@Override
	public List<Employee> getEmployeeListByEmpNameASC(List<Employee> employeeList){
		return employeeList.stream().sorted((e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName())).toList();
	}
	
	@Override
	public List<Employee> getEmployeeListByJoiningDateASC(List<Employee> employeeList){
		return employeeList.stream().sorted((e1, e2) -> e1.getJoiningDate().compareTo(e2.getJoiningDate())).toList();
	}

}
