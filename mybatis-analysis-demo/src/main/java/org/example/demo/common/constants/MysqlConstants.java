package org.example.demo.common.constants;

/**
 * @author liyunfei
 **/
public interface MysqlConstants {
     
     String DRIVER = "com.mysql.cj.jdbc.Driver";
     
     /**
      * JDBC连接；
      * 1.jdbc:mysql协议--属于应用层？
      * 2.关于该URL的写法，时区、超时等参数
      */
     String URL = "jdbc:mysql://127.0.0.1:3306/mybatis_practice?serverTimezone=UTC";
     
     // 用于MySQL的server的 连接层会先走 安全认证
     
     /**
      * 用户名
      */
     String USER_NAME = "root";
     
     /**
      * 密码
      */
     String PASSWORD = "123321";
     
}
