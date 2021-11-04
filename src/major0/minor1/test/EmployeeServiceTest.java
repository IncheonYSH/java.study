package major0.minor1.test;

import major0.minor1.service.EmployeeService;
import major0.minor1.vo.Engineer;

public class EmployeeServiceTest {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        Engineer engineer = new Engineer("001", "John", "Seoul", 4000, "java", 2000);
        employeeService.addEngineer(engineer);
        employeeService.printAllEmployees();
    }
}
