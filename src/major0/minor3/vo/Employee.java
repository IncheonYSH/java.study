package major0.minor3.vo;

import java.util.Objects;

//Super Class...
public class Employee {
	String empId;
	String name;
	String addr;
	int salary;
	
	public Employee() {	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return salary == employee.salary && Objects.equals(empId, employee.empId) && Objects.equals(name, employee.name) && Objects.equals(addr, employee.addr);
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, name, addr, salary);
	}

	public Employee(String empId, String name, String addr, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.addr = addr;
		this.salary = salary;
	}

	public String getEmpId() {
		return empId;
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
	
	
	public void setEmpId(String empId) {
		this.empId = empId;
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
		return "Employee [empId=" + empId + ", name=" + name + ", addr=" + addr
				+ ", salary=" + salary + "]";
	}		
}











