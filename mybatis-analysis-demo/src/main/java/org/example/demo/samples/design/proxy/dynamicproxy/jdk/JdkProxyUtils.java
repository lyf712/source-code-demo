package org.example.demo.samples.design.proxy.dynamicproxy.jdk;

import org.example.demo.samples.design.proxy.UserMapper;
import org.example.demo.samples.design.proxy.staticproxy.UserMapperImpl;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyunfei
 **/
public class JdkProxyUtils {
    
    //    private final static Map<String, Class<?>> map = new HashMap<>();
    //
    //    static {
    //        map.put(UserMapperImpl.class.getName(), UserMapper.class);
    //    }
    
    public static UserMapper userMapper(UserMapper rawUserMapper) {
        return (UserMapper) Proxy.newProxyInstance(rawUserMapper.getClass().getClassLoader(),
            new Class[] {UserMapper.class}, new JdkProxyUserMapper(rawUserMapper));
    }
    
    
    public static <T> T createProxyObj(Class<T> interfaceClazz, T target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
            new Class[] {interfaceClazz}, new JdkProxyHandler<>(target));
    }
}
