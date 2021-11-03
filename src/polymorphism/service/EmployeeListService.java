package polymorphism.service;


import polymorphism.vo.Employee;

import java.util.ArrayList;

public interface EmployeeListService {
	void addEmployee(Employee e);
	void deleteEmployee(String empId);
	void updateEmployee(Employee e);
	void showAll();

	//Method Overloading
	ArrayList<Employee> findEmployees(String addr);
	void findEmployees();
}
