package com.lyf.base.design.behavior.template;

/**
 * @author liyunfei
 **/
public class DepositService extends AbstractBankService{
    
    @Override
    void concreteHandle() {
        System.out.println("进行存钱");
    }
}
