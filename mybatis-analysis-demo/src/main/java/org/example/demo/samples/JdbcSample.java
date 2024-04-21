package org.example.demo.samples;

import org.example.demo.common.constants.MysqlConstants;
import org.example.demo.common.model.UserDO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 需要去关注： Driver,DriverManager,Connection几个关键类
 *
 * @author liyunfei
 **/
public class JdbcSample {
    
    public List<UserDO> sample() throws Exception {
        
        // step1: Java的对象，传参、绑定参数动作
        UserDO userParam = new UserDO();
        userParam.setId(1);
        userParam.setSex(0);
        userParam.setAge(21);
        userParam.setSchoolName("Sunny School");
        userParam.setEmail("OK");
        
        // 处理：初始化工作
        
        // step2: 加载驱动程序
        // mySQL,Derby,等数据库---
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // step3：创建连接 , 如何理解该连接？？ 长连接？？，可以后续复用？【具体Driver实现，Driver下面具有MySQL,Dervy,Sql Server等多种--】
        // Driver驱动去进行实际的连接，不同厂商的Driver不同--[SPI机制的研究] -- mysql-connector-java (5.x,8.x对比）
        // Connection同Session的区别
        // Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'.
        // The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary
        // MySQL：采用TCP/IP
        // 关于连接动作，见com.mysql.cj.jdbc.ConnectionImpl   this.createNewIO(false);
        // 理清 DataSource，DriverManger，Driver，Connection，之间的关系
//         * <P>The basic service for managing a set of JDBC drivers.<br>
// * <B>NOTE:</B> The {@link javax.sql.DataSource} interface, new in the
//            * JDBC 2.0 API, provides another way to connect to a data source.
// * The use of a <code>DataSource</code> object is the preferred means of
//            * connecting to a data source.
        
        Connection connection =
            DriverManager.getConnection(MysqlConstants.URL, MysqlConstants.USER_NAME,
                MysqlConstants.PASSWORD);
        
        // step4：语句并执行
        Statement statement = connection.createStatement();
        
        // step5: 创建SQL语句（与MySQL的server的执行命令）
        // 关注SqlRunner,和ScriptRunner
        // IDEA是如何识别，并提醒SQL的正确性（）
        String sql =
            "SELECT * FROM `user` WHERE school_name = '" + userParam.getSchoolName() + "';";
        ResultSet resultSet = statement.executeQuery(sql);
        
        String sql2 =
            "SELECT * FROM `user` WHERE school_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql2);
        //preparedStatement.executeQuery()
        preparedStatement.setString(1,"");
    
        // step6:处理数据结果
        // 参数的获取（根据字段名） --- 解析分析 Java对象 和 数据表的映射--
        List<UserDO> userDOList = new ArrayList<>();
        while (resultSet.next()) {
            UserDO user = new UserDO();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setAge(resultSet.getInt("age"));
            user.setSex(resultSet.getInt("sex"));
            user.setSchoolName(resultSet.getString("school_name"));
            userDOList.add(user);
        }
        
        userDOList.forEach(System.out::println);
        
        return userDOList;
    }
}
