package com.lyf.base.design.structure.adapter.obj_way;

/**
 * @author liyunfei
 **/
public class TargetWrapper extends Target{
    private Adaptee adaptee = new Adaptee();
    @Override
    public void targetMethod() {
        //super.targetMethod();
        adaptee.adapteeMethod();
    }
}
