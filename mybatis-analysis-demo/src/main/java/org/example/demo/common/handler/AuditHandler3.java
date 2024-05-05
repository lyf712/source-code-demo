package org.example.demo.common.handler;

import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 **/
@Component
public class AuditHandler3 implements AuditHandler<String,String>{
    
    @Override
    public String handle(String s) {
        return null;
    }
}
