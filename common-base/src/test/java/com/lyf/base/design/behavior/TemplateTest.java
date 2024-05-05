package com.lyf.base.design.behavior;

import com.lyf.base.design.behavior.template.AbstractBankService;
import com.lyf.base.design.behavior.template.DepositService;
import com.lyf.base.design.behavior.template.LoanService;
import org.junit.Test;

/**
 * @author liyunfei
 **/
public class TemplateTest {
    @Test
    public void test(){
        AbstractBankService service = new DepositService();
        service.process();
        service = new LoanService();
        service.process();
    }
}
