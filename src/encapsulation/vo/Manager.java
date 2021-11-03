package encapsulation.vo;

public class Manager {
    private String empId;
    private String name;
    private String addr;
    private int salary;
    private String dept;

    public Manager(String empId, String name, String addr, int salary, String dept) {
        this.empId = empId;
        this.name = name;
        this.addr = addr;
        this.salary = salary;
        this.dept = dept;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
