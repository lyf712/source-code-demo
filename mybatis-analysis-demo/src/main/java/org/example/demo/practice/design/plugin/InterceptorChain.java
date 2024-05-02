package org.example.demo.practice.design.plugin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author liyunfei
 **/
public class InterceptorChain {
    
    private final List<Interceptor> interceptorList = new ArrayList<>();
    
    public Object wrapPluginAll(Object target){
        for (Interceptor next : interceptorList) {
            target = (Interceptor) next.wrap(target);
        }
        return target;
    }
    
    
    public void addInterceptor(Interceptor interceptor){
        interceptorList.add(interceptor);
    }
    
}
