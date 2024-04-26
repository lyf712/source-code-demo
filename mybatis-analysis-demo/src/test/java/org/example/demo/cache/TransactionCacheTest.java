package org.example.demo.cache;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.demo.common.mapper.UserMapper;
import org.example.demo.common.model.AliasUser;
import org.example.demo.common.model.UserDO;
import org.example.demo.samples.myabtis.docs.SqlSessionFactoryRegistry;
import org.example.demo.samples.myabtis.docs.SqlSessionFactoryTypeEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author liyunfei
 **/
public class TransactionCacheTest {
    
    private SqlSessionFactory sqlSessionFactory;
    
    @Before
    public void setUp() {
        sqlSessionFactory =
            SqlSessionFactoryRegistry.getByType(SqlSessionFactoryTypeEnum.XML_CONFIG);
        
        
    }
    
    @Test
    public void test(){
        SqlSession session1 = sqlSessionFactory.openSession();
        SqlSession session2 = sqlSessionFactory.openSession();
        SqlSession session3 = sqlSessionFactory.openSession();
        UserMapper mapper = session1.getMapper(UserMapper.class);
    
        List<AliasUser> aliasUsers = mapper.queryAliasUsers();
        //        注解的方式，如何开启Cache配置？
        //        UserDO user = mapper.queryUserById(1);
//        System.out.println(user);
        session1.commit(true);
        mapper = session2.getMapper(UserMapper.class);
        List<AliasUser> aliasUsers2 = mapper.queryAliasUsers();
        
//        session2.commit(true);
//        mapper = session3.getMapper(UserMapper.class);
//        List<AliasUser> aliasUsers3 = mapper.queryAliasUsers();
        
        Assert.assertEquals(aliasUsers,aliasUsers2);
    }
    
    
    
}
