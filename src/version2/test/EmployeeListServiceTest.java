package version2.test;

import version3.service.EmployeeListService;
import version3.service.impl.MemoryEmployeeListService;
import version3.vo.Engineer;
import version3.vo.Manager;

public class EmployeeListServiceTest {
	//1. Service
	EmployeeListService service = MemoryEmployeeListService.getInstance();

	public void employeeTest() {
		//2. method
		System.out.println("======================== 1. add ================================== ");
		version3.vo.Manager m1 = new version3.vo.Manager("111", "manager1", "addr1", 500, "dept1");
		version3.vo.Manager m2 =new version3.vo.Manager("222", "manager2","addr2",400,"dept2");
		version3.vo.Manager m3 =new Manager("333", "manager3", "addr1", 600, "dept1");

		version3.vo.Engineer eg1 = new version3.vo.Engineer("444", "engineer1", "addr3", 450,"Python",100);
		version3.vo.Engineer eg2 =new Engineer("555", "engineer2", "addr4", 500, "JS",300);

		service.addEmployee(m1);
		service.showAll();
		System.out.println("===================");

		service.addEmployee(m2);
		service.showAll();
		System.out.println("===================");


		service.addEmployee(m3);
		service.showAll();
		System.out.println("===================");

		service.addEmployee(eg1);
		service.showAll();
		System.out.println("===================");

		service.addEmployee(eg2);
		service.showAll();
		System.out.println("===================");

		service.addEmployee(m3);
		service.showAll();
		System.out.println("===================");

		service.findEmployees();
		service.showAll();
		System.out.println("===================");

		System.out.println("======================== 2. delete ================================== ");
		service.deleteEmployee("111");

		service.findEmployees("111");

		System.out.println("========================");
	}

	public static void main(String[] args) {
		new version3.test.EmployeeListServiceTest().employeeTest();
	}
}