package org.example.demo.practice.design.plugin;

/**
 * @author liyunfei
 **/
public interface Interceptor {
   
    Object intercept(Invocation invocation);
    
    default Object wrap(Object targe){
        //return Plugin.
        return Plugin.wrap(targe,this);
    }
}
