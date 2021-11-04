package major0.minor4.connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 응집성을 높이기 위해서 커넥션 객체를 위한 새로운 클래스로 만들었다.
public interface Connector {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
