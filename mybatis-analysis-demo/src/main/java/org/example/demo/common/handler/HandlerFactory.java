package org.example.demo.common.handler;

import org.example.demo.common.web.request.AuditRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyunfei
 **/
@Component
public class HandlerFactory {
    
    @Autowired
    private Map<String, AuditHandler<Boolean, AuditRequest>> handlerMap = new HashMap<>();
    
    public AuditHandler<Boolean, AuditRequest> getHandler(String beanName) {
        return handlerMap.get(beanName);
    }
}
