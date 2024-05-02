package com.lyf.base.design.structure.adapter.class_way;

/**
 * @author liyunfei
 **/
public class TargetServiceAdapter extends AdapteeService implements TargetService {
    
    @Override
    public void targetMethod() {
        System.out.println("适配处理");
        super.adapteeMethod();
    }
}
