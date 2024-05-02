package com.lyf.base.design.structure.adapter.class_way;

/**
 * @author liyunfei
 **/
public class TargetRefClient {
    private TargetService targetService = new TargetServiceImpl();
    
    public void run(){
        targetService.targetMethod();
        targetService = new TargetServiceAdapter();
        targetService.targetMethod();
        //
        // new AdapteeService().adapteeMethod();
    }
}
