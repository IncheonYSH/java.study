package major0.minor3.service.impl;

import major0.minor3.service.EmployeeListService;
import major0.minor3.vo.Employee;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryEmployeeListService implements EmployeeListService {
	// 싱글톤
	private static class InnerInstance {
		private static final MemoryEmployeeListService instance = new MemoryEmployeeListService();
	}

	private ArrayList<Employee> list = new ArrayList<>();

	public static MemoryEmployeeListService getInstance(){
		return InnerInstance.instance;
	}

	private MemoryEmployeeListService(){
		// 기본 constructor
	}

	@Override
	public Optional<Employee> findByEmpId(String empId) {
		return list
				.stream()
				.filter(employee -> employee.getEmpId().equals(empId))
				.findFirst();
	}

	@Override
	public void addEmployee(Employee employee) {
		if (findByEmpId(employee.getEmpId()).isPresent()){
			return;
		}
		list.add(employee);
	}

	@Override
	public void deleteEmployee(String empId) {
		list.remove(findByEmpId(empId).orElseGet(() -> null));
	}

	@Override
	public void updateEmployee(Employee employee) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(employee)){
				list.set(i, employee);
				break;
			}
		}
	}

	@Override
	public void showAll(){
		list.stream().forEach(employee -> System.out.println(employee));
	}
}
