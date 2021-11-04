package major0.minor3.service;


import major0.minor3.vo.Employee;

import java.util.ArrayList;
import java.util.Optional;

public interface EmployeeListService {
	void addEmployee(Employee e);
	Optional<Employee> findByEmpId(String emplId);
	void deleteEmployee(String empId);
	void updateEmployee(Employee e);
	void showAll();

}
