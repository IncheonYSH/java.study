package major0.minor4.dto;

public class Engineer extends Employee {
	String tech;
	int bonus;

	public Engineer(long empId, String name, String addr, int salary, String employeeType, String tech, int bonus) {
		super(empId, name, addr, salary, employeeType);
		this.tech = tech;
		this.bonus = bonus;
	}

	public String getTech() {
		return tech;
	}

	public int getBonus() {
		return bonus;
	}
	
	public void setTech(String tech) {
        this.tech = tech;
    }

	public void setBonus(int bonus) {
        this.bonus = bonus;
    }

	public void changeTech(String tech) {
		this.tech = tech;
	}

	public void changeBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return super.toString()+" Engineer [tech=" + tech + ", bonus=" + bonus + "]";
	}	
}













