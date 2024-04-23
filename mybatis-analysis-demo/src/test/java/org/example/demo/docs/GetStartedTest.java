package org.example.demo.docs;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.demo.common.mapper.UserMapper;
import org.example.demo.common.model.AliasUser;
import org.example.demo.common.model.UserDO;
import org.example.demo.common.model.UserExample;
import org.example.demo.samples.myabtis.docs.SqlSessionFactoryRegistry;
import org.example.demo.samples.myabtis.docs.SqlSessionFactoryTypeEnum;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.instrument.Instrumentation;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 **/
public class GetStartedTest {
    
    private UserMapper userMapper;
    
    private SqlSession session;
    
    private Instrumentation instrumentation;
    
    @Before
    public void setUp() {
        SqlSessionFactory sqlSessionFactory =
            SqlSessionFactoryRegistry.getByType(SqlSessionFactoryTypeEnum.XML_CONFIG);
        //        try (SqlSession session = sqlSessionFactory.openSession()) {
        //            userMapper =  session.getMapper(UserMapper.class);
        //        }
        Configuration configuration = sqlSessionFactory.getConfiguration();
        System.out.printf("");
        session = sqlSessionFactory.openSession();
        if (session != null) {
            userMapper = session.getMapper(UserMapper.class);
        }
    }
    
    @After
    public void cleanUp() {
        if (session != null) {
            session.close();
        }
    }
    
    @Test
    public void testAcquireFactory() {
        SqlSessionFactory sqlSessionFactory =
            SqlSessionFactoryRegistry.getByType(SqlSessionFactoryTypeEnum.XML_CONFIG);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            UserDO userDO = userMapper.queryUserById(1);
            System.out.printf(">>>>测试>>>> Annotation Query %s \n", userDO);
            
            userDO =
                session.selectOne("org.example.demo.common.mapper.UserMapper.queryUserById", 1);
            System.out.printf(">>>>测试>>>> Annotation Query %s \n", userDO);
            
            AliasUser aliasUser = userMapper.queryAliasUserById(1);
            System.out.printf(">>>>测试>>>> Annotation Query %s \n", aliasUser);
        }
    }
    
    @Test
    public void testAlias() {
        final Integer id = 1;
        AliasUser aliasUser = userMapper.queryAliasUserById(id);
        Assert.assertNotNull(aliasUser);
        Assert.assertEquals(id, aliasUser.getId());
    }
    
    @Test
    public void testSelectResultMap() {
        List<AliasUser> aliasUsers = userMapper.queryAliasUsers();
        aliasUsers.stream().findAny().ifPresent(user -> {
            Assert.assertNotNull(user.getId());
            Assert.assertNotNull(user.getName());
            Assert.assertNotNull(user.getEmail());
            // resultMap 未做此段的映射，
            // 驼峰下划线的问题...需要注明，，否则为空
            //AliasUser(id=1, name=易哥, email=yeecode@sample.com, age=18, sex=0, schoolName=null)
            print(user);
        });
    }
    
    @Test
    public void testSQL() throws InterruptedException {
        UserExample userExample = new UserExample();
        userExample.setLimit(true);
        userExample.setLimitNum(5);
        List<AliasUser> aliasUsers = userMapper.queryAliasUsersByExample(userExample);
        Assert.assertNotNull(aliasUsers);
        Assert.assertTrue(aliasUsers.size()<=5);
        TimeUnit.SECONDS.sleep(100);
    }
    
    private void print(Object o) {
        System.out.printf("RES: %s", o);
    }
    
}
