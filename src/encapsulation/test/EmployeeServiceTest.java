package encapsulation.test;

import encapsulation.service.EmployeeService;
import encapsulation.vo.Engineer;

public class EmployeeServiceTest {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        Engineer engineer = new Engineer("001", "John", "Seoul", 4000, "java", 2000);
        employeeService.addEngineer(engineer);
        employeeService.printAllEmployees();
    }
}
