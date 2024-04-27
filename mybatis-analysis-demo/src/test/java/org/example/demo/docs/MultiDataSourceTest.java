package org.example.demo.docs;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.junit.Before;

import java.util.Properties;

/**
 * @author liyunfei
 **/
public class MultiDataSourceTest {
    
    private static final String driver_key =  "datasource.driver";
    private static final String url_key =  "datasource.url";
    private static final String username_key =  "datasource.username";
    private static final String password_key =  "datasource.password";
    
    private final Properties dataSourceProps1 = new Properties();
    private final Properties dataSourceProps2 = new Properties();
    
    @Before
    public void setUp(){
          dataSourceProps1.put("","");
    
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build()
    }
}
