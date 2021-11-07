package major0.minor4.dto;

public class Manager extends Employee {
	String dept;

	public Manager(long empId, String name, String addr, int salary, String employeeType, String dept) {
		super(empId, name, addr, salary, employeeType);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void changeDept(String dept) {
		this.dept = dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString()+" Manager [dept=" + dept + "]";
	}	
}
 