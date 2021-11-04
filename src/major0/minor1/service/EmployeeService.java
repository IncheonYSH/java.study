package major0.minor1.service;

import major0.minor1.vo.Engineer;
import major0.minor1.vo.Manager;

public class EmployeeService {
    private Engineer[] engineerList;
    private int engineerCount;
    private int engineerCapacity = 10;

    private Manager[] managerList;
    private int managerCount;
    private int managerCapacity = 10;

    public EmployeeService() {
        managerList = new Manager[managerCapacity];
        engineerList = new Engineer[engineerCapacity];
    }

    public void addManager(Manager manager) {
        if(managerCount == managerCapacity){
            Manager[] newManagerList = new Manager[managerCapacity * 2];
            System.arraycopy(managerList, 0, newManagerList, 0, managerCapacity);
            managerList = newManagerList;
            managerCapacity *= 2;
        }
        managerList[managerCount++] = manager;
    }

    public void addEngineer(Engineer engineer) {
        if(engineerCount == engineerCapacity){
            Engineer[] newEngineerList = new Engineer[engineerCapacity * 2];
            System.arraycopy(engineerList, 0, newEngineerList, 0, engineerCapacity);
            engineerList = newEngineerList;
            engineerCapacity *= 2;
        }
        engineerList[engineerCount++] = engineer;
    }

    public void deleteManager(int index) {
        for (int i = index; i < managerCount - 1; i++) {
            managerList[i] = managerList[i + 1];
        }
        managerCount--;
    }

    public void deleteEngineer(int index) {
        for (int i = index; i < engineerCount - 1; i++) {
            engineerList[i] = engineerList[i + 1];
        }
        engineerCount--;
    }

    public void updateManager(String empId, String name, String addr, int salary, String dept){
        for (int i = 0; i < managerCount; i++) {
            if (managerList[i].getEmpId().equals(empId)) {
                managerList[i].setName(name);
                managerList[i].setAddr(addr);
                managerList[i].setSalary(salary);
                managerList[i].setDept(dept);
            }
        }
    }

    public void updateEngineer(String empId, String name, String addr, int salary, String tech, int bonus){
        for (int i = 0; i < engineerCount; i++) {
            if (engineerList[i].getEmpId().equals(empId)) {
                engineerList[i].setName(name);
                engineerList[i].setAddr(addr);
                engineerList[i].setSalary(salary);
                engineerList[i].setTech(tech);
                engineerList[i].setBonus(bonus);
            }
        }
    }

    public Manager findManager(String empId){
        for (int i = 0; i < managerCount; i++) {
            if (managerList[i].getEmpId().equals(empId)) {
                return managerList[i];
            }
        }
        return null;
    }

    public Engineer findEngineer(String empId){
        for (int i = 0; i < engineerCount; i++) {
            if (engineerList[i].getEmpId().equals(empId)) {
                return engineerList[i];
            }
        }
        return null;
    }

    public void printAllManagers() {
        for (int i = 0; i < managerCount; i++) {
            System.out.println(managerList[i].getEmpId() + " " +
                    managerList[i].getName() + " " +
                    managerList[i].getAddr() + " " +
                    managerList[i].getSalary() + " " +
                    managerList[i].getDept());
        }
    }

    public void printAllEngineers() {
        for (int i = 0; i < engineerCount; i++) {
            System.out.println(engineerList[i].getEmpId() + " " +
                    engineerList[i].getName() + " " +
                    engineerList[i].getAddr() + " " +
                    engineerList[i].getSalary() + " " +
                    engineerList[i].getTech() + " " +
                    engineerList[i].getBonus());
        }
    }

    public void printAllEmployees() {
        printAllEngineers();
        printAllManagers();
    }
}
