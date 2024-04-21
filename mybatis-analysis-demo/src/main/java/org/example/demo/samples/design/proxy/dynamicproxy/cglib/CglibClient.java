package org.example.demo.samples.design.proxy.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author liyunfei
 **/
public class CglibClient {
    
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new ProxyHandler<>());
        enhancer.setSuperclass(UserServiceImpl.class);
    
        UserService userService = (UserServiceImpl)enhancer.create();
        userService.sayHello();
    }
}
