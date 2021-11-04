package version2.service;

import version2.vo.Employee;

public class EmployeeListService {
	// 싱글톤
	private static class InnerInstance {
		private static final EmployeeListService instance = new EmployeeListService();
	}

	private Employee[] employees = new Employee[10];
	private int count = 0;
	private int capacity = 10;

	public static EmployeeListService getInstance(){
		return InnerInstance.instance;
	}

	private EmployeeListService(){
		// 기본 constructor
	}

	private Employee findByEmpId(String empId) {
        for (Employee employee : employees) {
            if(employee.getEmpId().equals(empId)){
                return employee;
            }
        }
        return null;
	}

	public void addEmployee(Employee employee) {
		if(count == capacity){
            Employee[] newEmployees = new Employee[capacity * 2];
            System.arraycopy(employees, 0, newEmployees, 0, capacity);
            employees = newEmployees;
            capacity *= 2;
        }
        employees[count++] = employee;
    }

	public void deleteEmployee(String empId){
        for(int i = 0; i < count; i++){
            if(employees[i].getEmpId().equals(empId)){
                for(int j = i + 1; j < count; j++){
                    employees[j - 1] = employees[j];
                }
                count--;
                break;
            }
        }
    }

	public void updateEmployee(String empId, String name, String addr, int salary) {
        for(int i = 0; i < count; i++){
            if(employees[i].getEmpId().equals(empId)){
                employees[i].setName(name);
                employees[i].setAddr(addr);
                employees[i].setSalary(salary);
                break;
            }
        }
    }

	public void printAllEmployees(){
		for(int i = 0; i < count; i++){
            System.out.println(employees[i]);
        }
	}
}
