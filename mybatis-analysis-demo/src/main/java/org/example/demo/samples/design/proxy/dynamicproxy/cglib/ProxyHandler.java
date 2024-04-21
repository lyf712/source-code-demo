package org.example.demo.samples.design.proxy.dynamicproxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liyunfei
 **/
public class ProxyHandler <T> implements MethodInterceptor {
    
    
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
        throws Throwable {
        System.out.println("before working..");
        methodProxy.invokeSuper(o,objects);
        System.out.println("after working...");
        return null;
    }
}
