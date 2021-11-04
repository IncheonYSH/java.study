package major0.minor4.dao;

import major0.minor4.dto.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeServiceDao {
    void addEmployee(Employee employee) throws SQLException, ClassNotFoundException;
    Employee getEmployee(long id) throws SQLException, ClassNotFoundException;
    void updateEmployee(Employee employee) throws SQLException, ClassNotFoundException;
    void deleteEmployee(long id) throws SQLException, ClassNotFoundException;
    ArrayList<Employee> getAllEmployees() throws SQLException, ClassNotFoundException;
}
