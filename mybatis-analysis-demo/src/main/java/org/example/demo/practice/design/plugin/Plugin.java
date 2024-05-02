package org.example.demo.practice.design.plugin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liyunfei
 **/
public class Plugin implements InvocationHandler {
    
    private final Interceptor interceptor;
    
    private final Object target;
    
    public Plugin(Interceptor interceptor, Object target) {
        this.interceptor = interceptor;
        this.target = target;
    }
    
    public static Object wrap(Object target, Interceptor interceptor) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
            target.getClass().getInterfaces(), new Plugin(interceptor, target));
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 拦截器处理
        return interceptor.intercept(new Invocation(target, method, args));
        
        //method.invoke(target,args);
        
        //return null;
    }
}
