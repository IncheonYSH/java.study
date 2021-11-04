package major0.minor4.connector.Impl;

import major0.minor4.connector.Connector;

import java.sql.*;

public class MariadbConnector implements Connector {
    private static final String driver = "org.mariadb.jdbc.Driver";
    private static final String url = "jdbc:mariadb://127.0.0.1:3306/employee_service?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
    private static final String user = "root";
    private static final String password = "0000";

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
