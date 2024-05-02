package org.example.demo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.demo.samples.myabtis.docs.SqlSessionFactoryRegistry;
import org.example.demo.samples.myabtis.docs.SqlSessionFactoryTypeEnum;

/**
 * @author liyunfei
 **/
public abstract class BaseTest {
    
    protected SqlSessionFactory sqlSessionFactory;
    
    protected SqlSession defaultSession;
    
    protected void init(){
        sqlSessionFactory =
            SqlSessionFactoryRegistry.getByType(SqlSessionFactoryTypeEnum.XML_CONFIG);
        defaultSession = sqlSessionFactory.openSession();
    }
    
}
