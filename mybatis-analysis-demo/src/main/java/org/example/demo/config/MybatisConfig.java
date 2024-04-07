package org.example.demo.config;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * @author liyunfei
 **/
public class MybatisConfig {
    
    // 单例---
    
    public static Configuration configuration() {
        Configuration configuration = new Configuration();
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setUrl("");
        dataSource.setUser("");
        dataSource.setPassword("");
        Environment environment = new Environment("env1", new JdbcTransactionFactory(), dataSource);
        configuration.setEnvironment(environment);
        return configuration;
    }
    
    public static SqlSessionFactory sqlSessionFactory() {
        //sqlSessionFactory.openSession()
        return new DefaultSqlSessionFactory(configuration());
    }
    
}
