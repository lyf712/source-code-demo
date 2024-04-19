package org.example.demo.base;

import org.example.demo.common.constants.MysqlConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author liyunfei
 **/
@LyfAnnotation
public class JdbcManager {
    
    private volatile Connection connection;
    
    private static final class Holder {
        
        private static final JdbcManager INSTANCE = new JdbcManager();
    }
    
    public static JdbcManager getInstance() {
        JdbcManager instance = Holder.INSTANCE;
        instance.connect(MysqlConstants.URL, MysqlConstants.USER_NAME, MysqlConstants.PASSWORD);
        return instance;
    }
    
    private synchronized Connection connect(String url, String username, String password) {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
}
