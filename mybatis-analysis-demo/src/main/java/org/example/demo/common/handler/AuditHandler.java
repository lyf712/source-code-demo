package org.example.demo.common.handler;

/**
 * @author liyunfei
 **/
public interface AuditHandler<IN,OUT> {
    
    /**
     *
     * @param in
     * @return
     */
    OUT handle(IN in);
    
}
