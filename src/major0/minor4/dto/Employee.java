package major0.minor4.dto;

import java.util.Objects;

//Super Class...
public class Employee {
	long id;
	String name;
	String addr;
	int salary;
	String employeeType;
	
	public Employee() {	}

	public Employee(long empId, String name, String addr, int salary, String employeeType) {
		super();
		this.id = empId;
		this.name = name;
		this.addr = addr;
		this.salary = salary;
		this.employeeType = employeeType;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	public int getSalary() {
		return salary;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + id + ", name=" + name + ", addr=" + addr
				+ ", salary=" + salary + "]";
	}		
}











