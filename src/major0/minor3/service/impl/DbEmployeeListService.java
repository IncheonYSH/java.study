package major0.minor3.service.impl;

import major0.minor3.service.EmployeeListService;
import major0.minor3.vo.Employee;

import java.util.ArrayList;
import java.util.Optional;

public class DbEmployeeListService implements EmployeeListService {
    @Override
    public void addEmployee(Employee e) {

    }

    @Override
    public Optional<Employee> findByEmpId(String emplId) {
        return Optional.empty();
    }

    @Override
    public void deleteEmployee(String empId) {

    }

    @Override
    public void updateEmployee(Employee e) {

    }

    @Override
    public void showAll() {

    }
}
