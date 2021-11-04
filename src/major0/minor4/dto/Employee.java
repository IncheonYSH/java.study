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

	@Override
	public int hashCode() {
		return Objects.hash(id, name, addr, salary, employeeType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (addr == null) {
            if (other.addr != null)
                return false;
        } else if (!addr.equals(other.addr))
            return false;
        if (salary != other.salary)
            return false;
        if (employeeType == null) {
            if (other.employeeType != null)
                return false;
        } else if (!employeeType.equals(other.employeeType))
            return false;
        return true;
    }

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











