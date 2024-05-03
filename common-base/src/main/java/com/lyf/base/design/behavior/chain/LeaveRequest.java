package com.lyf.base.design.behavior.chain;

/**
 * @author liyunfei
 **/
public class LeaveRequest extends BaseRequest{
    
    private Long days;
    
    private String username;
    
    private String reason;
    
    public LeaveRequest(Long days, String username, String reason) {
        this.days = days;
        this.username = username;
        this.reason = reason;
    }
    
    public Long getDays() {
        return days;
    }
    
    public void setDays(Long days) {
        this.days = days;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
}
