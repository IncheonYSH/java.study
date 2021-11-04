package major0.minor4.service.impl;

import major0.minor4.dao.EmployeeServiceDao;
import major0.minor4.dao.impl.EmployeeServiceDaoImpl;
import major0.minor4.dto.Employee;
import major0.minor4.service.EmployeeService;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeServiceDao employeeServiceDao = EmployeeServiceDaoImpl.getInstance();

    @Override
    public void registerEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        if (employeeServiceDao.getEmployee(employee.getId()) == null) {
            employeeServiceDao.addEmployee(employee);
        }
    }

    @Override
    public Employee getEmployee(long id) throws SQLException, ClassNotFoundException {
        return employeeServiceDao.getEmployee(id);
    }

    @Override
    public void deleteEmployee(long id) throws SQLException, ClassNotFoundException {
        employeeServiceDao.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        employeeServiceDao.updateEmployee(employee);
    }

    @Override
    public ArrayList<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
        return employeeServiceDao.getAllEmployees();
    }
}
