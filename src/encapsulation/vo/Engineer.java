package encapsulation.vo;

public class Engineer {
    private String empId;
    private String name;
    private String addr;
    private int salary;
    private String tech;
    private int bonus;

    public Engineer(String empId, String name, String addr, int salary, String tech, int bonus) {
        this.empId = empId;
        this.name = name;
        this.addr = addr;
        this.salary = salary;
        this.tech = tech;
        this.bonus = bonus;
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

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
