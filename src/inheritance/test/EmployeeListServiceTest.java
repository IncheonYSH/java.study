package inheritance.test;

import inheritance.service.EmployeeListService;
import inheritance.vo.Engineer;
import inheritance.vo.Manager;

public class EmployeeListServiceTest {

	public static void main(String[] args) {
		//1. Service
		EmployeeListService service = EmployeeListService.getInstance();
				
				
		//2. method
		System.out.println("======================== 1. add ================================== ");
		Manager m1 = new Manager("111", "manager1", "addr1", 500, "dept1");
		Manager m2 =new Manager("222", "manager2","addr2",400,"dept2");
		Manager m3 =new Manager("333", "manager3", "addr1", 600, "dept1");
		
		Engineer eg1 = new Engineer("444", "engineer1", "addr3", 450,"Python",100);
		Engineer eg2 =new Engineer("555", "engineer2", "addr4", 500, "JS",300);
		
		service.addEmployee(m1);
		service.printAllEmployees();
		System.out.println("===================");
		service.addEmployee(m2);
		service.printAllEmployees();
		System.out.println("===================");
		service.addEmployee(m3);
		service.printAllEmployees();
		System.out.println("===================");
		service.addEmployee(eg1);
		service.printAllEmployees();
		System.out.println("===================");
		service.addEmployee(eg2);
		service.printAllEmployees();
		System.out.println("===================");
		service.addEmployee(m3);
		service.printAllEmployees();
		System.out.println("======================== 2. delete ================================== ");
		service.deleteEmployee("111");
		service.printAllEmployees();
		System.out.println("========================");
		service.deleteEmployee("0");
		service.printAllEmployees();
		System.out.println("========================");
		service.deleteEmployee("333");
		service.printAllEmployees();
		System.out.println("======================== 3. update ================================== ");
		service.updateEmployee("222", "engineer1", "addr222", 450);
		service.printAllEmployees();
		System.out.println("========================");
		service.updateEmployee("0", "engineer1", "addr222", 450);
		service.printAllEmployees();
		System.out.println("========================");
	}
}
