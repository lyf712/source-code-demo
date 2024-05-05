package com.lyf.base.design.behavior.chain;

/**
 * ROLE: 角色--小组长
 *
 * @author liyunfei
 **/
public class LeavePureHandler1 extends BasePureHandler<LeaveRequest, Boolean> {
    
    private final static Long MAX_DAY = 10L;
    
    private final String name;
    
    public LeavePureHandler1(String name) {
        this.name = name;
    }
    
    @Override
    boolean canHandle(LeaveRequest request) {
        Long days = request.getDays();
        // 此处则是规则，可结合 策略模式？
        // 若此处的处理规则复杂了、变化了、灵活了，则可以抽一个策略模式。
        // 机器的自定义规则
        return days < MAX_DAY;
    }
    
    @Override
    Boolean handle0(LeaveRequest request) {
        // 人工介入，查看请假理由等信息。【先写死，，机器定义】
        // 思考人工介入，卡住这个状态？
        return request.getReason().contains("生病");
    }
}
