package org.example.demo.common.service.impl;

import org.example.demo.common.handler.AuditHandler;
import org.example.demo.common.service.AuditService;
import org.example.demo.common.web.request.AuditRequest;
import org.example.demo.common.web.vo.AuditResp;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author liyunfei
 **/
@Service
public class AuditServiceImpl implements AuditService {
    
    @Autowired
    private List<AuditHandler<Boolean,AuditRequest>> handlerList;
    
    @Autowired
    private Map<String,AuditHandler<Boolean,AuditRequest>> handlerMap;
    
    @Autowired
    private Map<String,AuditHandler> handlerMapAll;
    
    @Override
    public AuditResp audit(AuditRequest auditRequest) {
        return null;
    }
    

}
