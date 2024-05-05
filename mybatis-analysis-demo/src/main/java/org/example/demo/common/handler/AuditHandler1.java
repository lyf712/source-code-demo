package org.example.demo.common.handler;

import org.example.demo.common.web.request.AuditRequest;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 **/
@Component
public class AuditHandler1 implements AuditHandler<Boolean, AuditRequest> {
    
    
    @Override
    public AuditRequest handle(Boolean aBoolean) {
        return null;
    }
}
