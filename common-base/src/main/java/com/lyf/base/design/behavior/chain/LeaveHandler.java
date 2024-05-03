package com.lyf.base.design.behavior.chain;

/**
 * @author liyunfei
 **/
public class LeaveHandler implements Handler<LeaveRequest,Boolean>{
    
    /**
     *
     * @param request LeaveRequest
     * @return 是否批准（，也可以设计完整的批准信息
     */
    @Override
    public Boolean handle(LeaveRequest request) {
        return null;
    }
}
