package org.example.demo;

import org.apache.ibatis.binding.MapperProxyFactory;
import org.example.demo.common.model.UserDO;
import org.example.demo.samples.design.proxy.UserMapper;
import org.example.demo.samples.design.proxy.dynamicproxy.jdk.JdkProxyUtils;
import org.example.demo.samples.design.proxy.staticproxy.ProxyUserMapper;
import org.example.demo.samples.design.proxy.staticproxy.UserMapperImpl;
import org.junit.Test;

/**
 * @author liyunfei
 **/
public class ProxyDesignTests {
    
    @Test
    public void testStaticProxy(){
        // 代理的实现方式可以继续拓展--
        UserMapperImpl userMapperImpl = new UserMapperImpl();
        UserMapper userMapper = new ProxyUserMapper(userMapperImpl);
        userMapper.insert(new UserDO());
    }
    
    /**
     * @see MapperProxyFactory
     */
    @Test
    public void testJdkProxy(){
        UserMapper userMapperImpl = new UserMapperImpl();
        JdkProxyUtils.createProxyObj(UserMapper.class,userMapperImpl).insert(new UserDO());
        //JdkProxyUtils.userMapper(userMapperImpl).insert(new UserDO());
    
       // UserMapper proxyObj = JdkProxyUtils.getProxyObj(userMapperImpl);
       // proxyObj.insert(new UserDO());
        
        // for @Mapper,
        // Map.put(Mapper.class,ObjProxy)
        // get(Mapper.class, 获取代理对象--
        
        // @to see   return Proxy.newProxyInstance(this.mapperInterface.getClassLoader(), new Class[]{this.mapperInterface}, mapperProxy);
        // MapperProxyFactory
    }
}
