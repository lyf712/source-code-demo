package org.example.demo.samples.myabtis.docs;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author liyunfei
 **/
public interface SimpleSqlSessionFactoryBuilder {
    
    /**
     *
     * @return SqlSessionFactory
     */
    SqlSessionFactory build();
}
