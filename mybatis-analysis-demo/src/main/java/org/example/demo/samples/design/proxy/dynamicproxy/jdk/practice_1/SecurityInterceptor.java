package org.example.demo.samples.design.proxy.dynamicproxy.jdk.practice_1;

/**
 * @author liyunfei
 **/
public interface SecurityInterceptor {
    
    
    Object execute(Object[] arg);
    
    InterceptorType type();
    
}
