package org.example.demo.common.service;

import org.example.demo.common.web.request.AuditRequest;
import org.example.demo.common.web.vo.AuditResp;

/**
 * @author liyunfei
 **/
public interface AuditService {
    
    /**
     *
     * @param auditRequest req
     * @return resp
     */
    AuditResp audit(AuditRequest auditRequest);
    
}
