package com.masaischool.ui;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.masaischool.dto.Employee;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.service.EmployeeServiceImpl;
import com.masaischool.service.IEmployeeService;

public class UIMain {
	static void insertEmployee(Scanner sc) {
		System.out.print("Enter employee Id ");
		String empId = sc.next();	//E001
		System.out.print("Enter employee name ");
		String empName = sc.next();	//BCD
		System.out.print("Enter annual salary ");
		double annualSalary = sc.nextDouble();	//20.25
		System.out.print("Enter joining date (YYYY-MM-DD) ");
		LocalDate joiningDate = LocalDate.parse(sc.next()) ;	//2023-01-10
		
		//Create an object of DTO
		Employee employee = new Employee(empId, empName, annualSalary, joiningDate);
		
		//Create an object of the IEmployeeService
		IEmployeeService employeeService = new EmployeeServiceImpl();
		try {
			employeeService.addEmployee(employee);
			System.out.println("Employee added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void viewEmployees(Scanner sc) {
		//Create an object of the IEmployeeService
		IEmployeeService employeeService = new EmployeeServiceImpl();
		
		try {
			List<Employee> employeeList = employeeService.getEmployeeList();
			
			int choice;
			System.out.println("1. See in the order of EmpId DESC");
			System.out.println("2. See in the order of EmpName ASC");
			System.out.println("3. See in the order of joiningDate ASC");
			System.out.print("Please enter selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					employeeService.getEmployeeListByEmpIdDESC(employeeList).stream().forEach(System.out::println);
					break;
				case 2:
					employeeService.getEmployeeListByEmpNameASC(employeeList).stream().forEach(System.out::println);
					break;
				case 3:
					employeeService.getEmployeeListByJoiningDateASC(employeeList).stream().forEach(System.out::println);
					break;
				default:
					employeeList.stream().forEach(System.out::println);
			}
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
				
	}
	
	static void updateEmployee(Scanner sc) {
		System.out.print("Enter employee Id ");
		String empId = sc.next();	//E001
		System.out.print("Enter employee name ");
		String empName = sc.next();	//BCD
		System.out.print("Enter annual salary ");
		double annualSalary = sc.nextDouble();	//20.25
		System.out.print("Enter joining date (YYYY-MM-DD) ");
		LocalDate joiningDate = LocalDate.parse(sc.next()) ;	//2023-01-10
		
		//Create an object of DTO
		Employee employee = new Employee(empId, empName, annualSalary, joiningDate);

		//Create an object of the IEmployeeService
		IEmployeeService employeeService = new EmployeeServiceImpl();
		try {
			employeeService.updateEmployee(employee);
			System.out.println("Employee update successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void deleteEmployee(Scanner sc) {
		System.out.print("Enter employee Id ");
		String empId = sc.next();	//E001

		//Create an object of the IEmployeeService
		IEmployeeService employeeService = new EmployeeServiceImpl();
		try {
			employeeService.deleteEmployee(empId);
			System.out.println("Employee deleted successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
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
					viewEmployees(sc);
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
