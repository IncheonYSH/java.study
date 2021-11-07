package major0.minor4.test;

import major0.minor4.connector.Connector;
import major0.minor4.connector.Impl.MariadbConnector;
import major0.minor4.dto.Employee;
import major0.minor4.dto.Engineer;
import major0.minor4.dto.Manager;
import major0.minor4.service.EmployeeService;
import major0.minor4.service.impl.EmployeeServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class EmployeeListServiceTest {
	// Service
	private static final EmployeeService service = new EmployeeServiceImpl();

	// 데이터베이스 초기화
	private static void resetDatabase(){
		Connector connector = new MariadbConnector();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connector.getConnection();
			preparedStatement = connection.prepareStatement("delete from employee");
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement("alter table employee auto_increment = 0");
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (preparedStatement != null) preparedStatement.close();
				if (connection != null) connection.close();
			}catch (Exception e) {
					e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		resetDatabase();
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
			// 등록
			service.registerEmployee(engineer1);
			service.registerEmployee(engineer2);
			service.registerEmployee(manager1);
			service.registerEmployee(manager2);

			// 중복 등록
			service.registerEmployee(engineer1);

			// 삭제
			service.deleteEmployee(1L);

			// 수정
			engineer2.setSalary(0);
			service.updateEmployee(engineer2);

			// 존재하지 않는 사원 수정
			engineer1.setSalary(0);
			service.updateEmployee(engineer1);

			// 조회
			System.out.println(service.getEmployee(2L));

			// 조회
			System.out.println(service.getEmployee(3L));

			// 존재하지 않는 사원 조회(return null)
			System.out.println(service.getEmployee(5L));

			ArrayList<Employee> employees = service.getAllEmployees();
			for (Employee employee : employees ) {
				System.out.println(employee);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
//      출력값
//		Employee [empId=2, name=Tom, addr=seoul, salary=0] Engineer [tech=java, bonus=2000]
//		Employee [empId=3, name=Jack, addr=seoul, salary=5000] Manager [dept=sales]
//		null
//		Employee [empId=2, name=Tom, addr=seoul, salary=0] Engineer [tech=java, bonus=2000]
//		Employee [empId=3, name=Jack, addr=seoul, salary=5000] Manager [dept=sales]
//		Employee [empId=4, name=Jill, addr=seoul, salary=5000] Manager [dept=sales]
	}
}
