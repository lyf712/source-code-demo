package org.example.demo.samples.myabtis.docs;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author liyunfei
 **/
public class SimpleXmlSqlSessionFactoryBuilder implements SimpleSqlSessionFactoryBuilder{
    
    @Override
    public SqlSessionFactory build() {
        // 1. 加载配置文件（config文件）
        String configFile = "mybatis/mybatis-config.xml";
        InputStream inputStream = null;
        // 对ClassLoader进行了加载，RPC项目中进行对Class的扫描：直接采用的
        // Thread.currentThread().getContextClassLoader().getResourceAsStream()
        // JVM的基础类加载知识
        try {
            inputStream = Resources.getResourceAsStream(configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    
        // 2. 构建SQL Session org.apache.ibatis.session.SqlSessionFactory
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
}
