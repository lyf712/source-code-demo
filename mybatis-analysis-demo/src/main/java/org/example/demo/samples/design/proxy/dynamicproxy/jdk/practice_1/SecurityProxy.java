package org.example.demo.samples.design.proxy.dynamicproxy.jdk.practice_1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liyunfei
 **/
public class SecurityProxy<T> implements InvocationHandler {
    
    protected final T target;
    
    protected  SecurityInterceptor interceptor;
    
    public SecurityProxy(T target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().equals(Object.class)) {
            return method.invoke(this, args);
        }
        
        // 安全处理
        if (interceptor == null) {
            return method.invoke(target, args);
        }
        
        // 以下可以抽象为 Invocker...,Invocationb
        
        if(interceptor.type()==InterceptorType.BEFORE){
            Boolean rs =(Boolean) interceptor.execute(args);
            if(!rs){
                return null;
            }
        }
    
        Object invoke = method.invoke(target, args);
        
        interceptor.execute((Object[]) invoke);
    
        return invoke;
    }
    
    //public T newInstance()
}
