package org.example.demo.session;

import org.example.demo.BaseTest;
import org.example.demo.common.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;

/**
 * @author liyunfei
 **/
public class SessionTest extends BaseTest {
    
    @Before
    public void setUp(){
        init();
    }
    
    @Test
    public void test(){
        UserMapper mapper = defaultSession.getMapper(UserMapper.class);
        mapper.queryAliasUsers();
        
    }
    
}
