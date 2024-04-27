package org.example.demo.samples.design.proxy.dynamicproxy.jdk.practice_1;

/**
 * @author liyunfei
 **/
public class ContollerSecurityProxy extends SecurityProxy<BaseController> {
    
    public ContollerSecurityProxy(BaseController target) {
        super(target);
    }
    
    public ContollerSecurityProxy(BaseController target, SecurityInterceptor interceptor) {
        super(target);
        super.interceptor = interceptor;
    }
    
}
