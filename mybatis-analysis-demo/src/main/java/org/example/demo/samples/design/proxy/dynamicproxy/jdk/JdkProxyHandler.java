package org.example.demo.samples.design.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liyunfei
 **/
public class JdkProxyHandler<T> implements InvocationHandler {
    
    private T target;
    
    public JdkProxyHandler(T target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.printf("proxy class:%s,object:%s ; target obj:%s ; method:%s", proxy.getClass(),
//            proxy, target, method);
    
        System.out.println("before");
        Object invoke = method.invoke(target, args);
        System.out.println("after");
        return invoke;
    }
}
