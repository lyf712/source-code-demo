package com.lyf.base.design.behavior.template;

/**
 * @author liyunfei
 **/
public class LoanService extends AbstractBankService{
    
    @Override
    void concreteHandle() {
        System.out.println("进行贷款");
    }
    
    @Override
    boolean isPrintT() {
        
        return false;// super.isPrintT();
    }
}
