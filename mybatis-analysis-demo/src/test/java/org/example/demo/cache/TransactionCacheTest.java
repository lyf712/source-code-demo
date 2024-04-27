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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyunfei
 **/
public class TransactionCacheTest {
    
    private SqlSessionFactory sqlSessionFactory;
    
    private SqlSession defaultSession;
    
    private Map<String, Object> localCache;// = new ConcurrentHashMap<>();
    
    @Before
    public void setUp() {
        sqlSessionFactory =
            SqlSessionFactoryRegistry.getByType(SqlSessionFactoryTypeEnum.XML_CONFIG);
        
        defaultSession = sqlSessionFactory.openSession();
        
        localCache = new ConcurrentHashMap<>();
    }
    
    @Test
    public void test() {
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
        
        Assert.assertEquals(aliasUsers, aliasUsers2);
    }
    
    @Test
    public void testLocalCache() {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<AliasUser> aliasUsers = mapper.queryAliasUsers();
        aliasUsers = mapper.queryAliasUsers();
        aliasUsers = mapper.queryAliasUsers();
    }
    
    @Test
    public void testLocalCache_1() {
        
        UserMapper mapper = defaultSession.getMapper(UserMapper.class);
        List<AliasUser> aliasUsers = mapper.queryAliasUsers();
    }
    
    @Test
    public void testLocalCache_2() {
        
        UserMapper mapper = defaultSession.getMapper(UserMapper.class);
        List<AliasUser> aliasUsers = mapper.queryAliasUsers();
    }
    
    @Test
    public void testCache_0() throws InterruptedException {
        
        Runnable runnable = () -> {
            UserMapper mapper = defaultSession.getMapper(UserMapper.class);
            List<AliasUser> aliasUsers = mapper.queryAliasUsers();
        };
        
        //new Thread(runnable,"thread-1").start();
        Thread thread1 = new Thread(runnable,"thread-1");
        Thread thread2 = new Thread(runnable,"thread-2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
    
    @Test
    public void testCache_3() {
        localCache.put("ok", "");
        System.out.println(localCache.get("ok"));
        System.out.println("....");
    }
    
    @Test
    public void testCache_4() {
        System.out.println("start....");
        System.out.println(localCache.get("ok"));
        System.out.println("....");
    }
}
