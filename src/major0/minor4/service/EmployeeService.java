package major0.minor4.service;

import major0.minor4.dto.Employee;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeService {
    void registerEmployee(Employee employee) throws SQLException, ClassNotFoundException;
    Employee getEmployee(long id) throws SQLException, ClassNotFoundException;
    void deleteEmployee(long empId) throws SQLException, ClassNotFoundException;
    void updateEmployee(Employee employee) throws SQLException, ClassNotFoundException;
    ArrayList<Employee> getAllEmployees() throws SQLException, ClassNotFoundException;
}
