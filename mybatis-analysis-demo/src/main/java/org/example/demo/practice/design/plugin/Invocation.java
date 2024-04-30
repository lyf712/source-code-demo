package org.example.demo.practice.design.plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liyunfei
 **/
public class Invocation {

    private final Object target;
    
    private final Method method;
    
    private final Object[]args;
    
    public Invocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }
    
    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target,args);
    }
    
}
