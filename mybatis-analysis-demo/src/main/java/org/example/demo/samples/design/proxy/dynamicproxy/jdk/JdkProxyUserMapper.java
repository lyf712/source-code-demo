package org.example.demo.samples.design.proxy.dynamicproxy.jdk;

import org.example.demo.samples.design.proxy.UserMapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liyunfei
 **/
public class JdkProxyUserMapper implements InvocationHandler {
    
    private UserMapper proxyTarget;
    
    public JdkProxyUserMapper(UserMapper proxyTarget) {
        this.proxyTarget = proxyTarget;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before...");
        Object invoke = method.invoke(proxyTarget, args);
        System.out.println("after...");
        return invoke;
    }
}
