package major0.minor3.service;


import major0.minor3.vo.Employee;

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
