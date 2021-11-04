package major0.minor4.test;

import major0.minor4.connector.Connector;
import major0.minor4.dto.Employee;
import major0.minor4.dto.Engineer;
import major0.minor4.dto.Manager;
import major0.minor4.service.EmployeeService;
import major0.minor4.service.impl.EmployeeServiceImpl;

import java.util.ArrayList;

public class EmployeeListServiceTest {
	//1. Service
	private static final EmployeeService service = new EmployeeServiceImpl();

	public static void main(String[] args) {
		Engineer engineer1 = new Engineer(
				1L,
				"John",
				"seoul",
				4000,
				"engineer",
				"java",
				2000
		);

		Engineer engineer2 = new Engineer(
				2L,
		        "Tom",
		        "seoul",
		        4000,
		        "engineer",
		        "java",
		        2000
		);

		Manager manager1 = new Manager(
				3L,
		        "Jack",
		        "seoul",
		        5000,
		        "manager",
		        "sales"
		);

		Manager manager2 = new Manager(
				4L,
		        "Jill",
		        "seoul",
		        5000,
		        "manager",
		        "sales"
		);

		try{
			service.registerEmployee(engineer1);
			service.registerEmployee(engineer2);
			service.registerEmployee(manager1);
			service.registerEmployee(manager2);
			System.out.println("등록 성공");

			service.registerEmployee(engineer1);
			System.out.println("등록 실패");

			service.deleteEmployee(1L);
			System.out.println("삭제 성공");

			engineer2.setSalary(0);
			service.updateEmployee(engineer2);
			System.out.println("수정 성공");

			engineer1.setSalary(0);
			service.updateEmployee(engineer1);
			System.out.println("수정 실패");

			System.out.println(service.getEmployee(2L));
			System.out.println(service.getEmployee(3L));
			System.out.println(service.getEmployee(5L));

			ArrayList<Employee> employees = service.getAllEmployees();
			for (Employee employee : employees ) {
				System.out.println(employee);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
