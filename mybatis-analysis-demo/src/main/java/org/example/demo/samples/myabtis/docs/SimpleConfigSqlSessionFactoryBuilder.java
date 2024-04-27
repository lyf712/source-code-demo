package org.example.demo.samples.myabtis.docs;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.example.demo.common.constants.MysqlConstants;
import org.example.demo.common.mapper.UserMapper;

import javax.sql.DataSource;

/**
 * 无xml-config配置，
 *
 * @author liyunfei
 **/
public class SimpleConfigSqlSessionFactoryBuilder implements SimpleSqlSessionFactoryBuilder {
    
    private static final SqlSessionFactoryBuilder INTERNAL_BUILDER = new SqlSessionFactoryBuilder();
    
    @Override
    public SqlSessionFactory build() {
        PooledDataSource dataSource =
            new PooledDataSource(MysqlConstants.DRIVER, MysqlConstants.URL,
                MysqlConstants.USER_NAME, MysqlConstants.PASSWORD);
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration();
        configuration.setCacheEnabled(true);
        // 添加Mapper
        configuration.addMapper(UserMapper.class);
        configuration.setEnvironment(environment);
        return INTERNAL_BUILDER.build(configuration);
    }
    
}
