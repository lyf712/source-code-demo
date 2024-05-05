package com.lyf.base.design.behavior.template;

import java.util.Random;

/**
 * @author liyunfei
 **/
public abstract class AbstractBankService {
    
    // 模板方法，形成规律性
    public final void process() {
        takeTicket();
        concreteHandle();
        evaluate();
        if(isPrintT()){
            print();
        }
    }
    
    protected void takeTicket() {
        System.out.println("获取排号：" + new Random().nextInt());
    }
    
    // 交由子类实现
    abstract void concreteHandle();
    
    protected void evaluate(){
        System.out.println("评分...");
    }
    
    // 钩子函数，默认打印凭据，子类可去覆盖
    boolean isPrintT(){
        return true;
    }
    
    protected void print(){
        System.out.println("打印凭据....");
    }
}
