package major0.minor4.dao.impl;

import major0.minor4.connector.Connector;
import major0.minor4.connector.Impl.MariadbConnector;
import major0.minor4.dao.EmployeeServiceDao;
import major0.minor4.dto.Employee;
import major0.minor4.dto.Engineer;
import major0.minor4.dto.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeServiceDaoImpl implements EmployeeServiceDao {
    // thread safe singleton with inner class
    private static class EmployeeServiceHolder {
        private static final EmployeeServiceDaoImpl INSTANCE = new EmployeeServiceDaoImpl();
    }

    private EmployeeServiceDaoImpl() {
    }

    public static final EmployeeServiceDaoImpl getInstance() {
        return EmployeeServiceHolder.INSTANCE;
    }

    // connector 선언
    private final Connector connector = new MariadbConnector();

    // close 메서드는 private 으로 선언하고, 각각의 메서드에서 호출하도록 한다. 인터페이스에 정의하지 않는다.
    // 필드와 어떠한 관련도 없이 그저 가독성과 유지보수성을 위해 선언한 메서드이기 때문이다.
    private void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    private void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        Connection conn = connector.getConnection();
        PreparedStatement ps = null;
        try {
            if (employee instanceof Engineer){
                ps = conn.prepareStatement("insert into employee(name, addr, salary, employee_type, tech, bonus) values(?,?,?,?,?,?)");
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getAddr());
                ps.setInt(3, employee.getSalary());
                ps.setString(4, employee.getEmployeeType());
                ps.setString(5, ((Engineer) employee).getTech());
                ps.setInt(6, ((Engineer) employee).getBonus());
                ps.executeUpdate();
            }else if (employee instanceof Manager){
                ps = conn.prepareStatement("insert into employee(name, addr, salary, employee_type, dept) values(?,?,?,?,?)");
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getAddr());
                ps.setInt(3, employee.getSalary());
                ps.setString(4, employee.getEmployeeType());
                ps.setString(5, ((Manager) employee).getDept());
                ps.executeUpdate();
            }else{
                throw new ClassNotFoundException("올바르지 않은 직원 유형입니다.");
            }
        }finally {
            closeAll(ps, conn);
        }
    }

    @Override
    public Employee getEmployee(long id) throws SQLException, ClassNotFoundException {

        Connection conn = connector.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from employee where id = ?");
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String addr = rs.getString("addr");
                int salary = rs.getInt("salary");
                String employeeType = rs.getString("employee_type");
                if (employeeType.equals("engineer")) {
                    String tech = rs.getString("tech");
                    int bonus = rs.getInt("bonus");
                    return new Engineer(id, name, addr, salary, employeeType, tech, bonus);
                }
                if (employeeType.equals("manager")) {
                    String dept = rs.getString("dept");
                    return new Manager(id, name, addr, salary, employeeType, dept);
                }
            }
        } finally {
            closeAll(rs, ps, conn);
        }
        return null;

    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        Connection conn = connector.getConnection();
        PreparedStatement ps = null;
        try {
            if (employee instanceof Engineer){
                ps = conn.prepareStatement("update employee set name=?, addr=?, salary=?, employee_type=?, tech=?, bonus=? where id=?");
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getAddr());
                ps.setInt(3, employee.getSalary());
                ps.setString(4, employee.getEmployeeType());
                ps.setString(5, ((Engineer) employee).getTech());
                ps.setInt(6, ((Engineer) employee).getBonus());
                ps.setLong(7, employee.getId());
                ps.executeUpdate();
            }else if (employee instanceof Manager){
                ps = conn.prepareStatement("update employee set name=?, addr=?, salary=?, employee_type=?, dept=? where id=?");
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getAddr());
                ps.setInt(3, employee.getSalary());
                ps.setString(4, employee.getEmployeeType());
                ps.setString(5, ((Manager) employee).getDept());
                ps.setLong(6, employee.getId());
                ps.executeUpdate();
            }else{
                throw new ClassNotFoundException("존재하지 않는 직원 입니다.");
            }
        }finally {
            closeAll(ps, conn);
        }
    }

    @Override
    public void deleteEmployee(long id) throws SQLException, ClassNotFoundException {
        Connection conn = connector.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from employee where id = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
        } finally {
            closeAll(ps, conn);
        }
    }

    @Override
    public ArrayList<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
        Connection conn = connector.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from employee");
            rs = ps.executeQuery();
            ArrayList<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String addr = rs.getString("addr");
                int salary = rs.getInt("salary");
                String employeeType = rs.getString("employee_type");
                if (employeeType.equals("engineer")) {
                    String tech = rs.getString("tech");
                    int bonus = rs.getInt("bonus");
                    employees.add(new Engineer(id, name, addr, salary, employeeType, tech, bonus));
                }
                if (employeeType.equals("manager")) {
                    String dept = rs.getString("dept");
                    employees.add(new Manager(id, name, addr, salary, employeeType, dept));
                }
            }
            return employees;
        } finally {
            closeAll(rs, ps, conn);
        }
    }
}

