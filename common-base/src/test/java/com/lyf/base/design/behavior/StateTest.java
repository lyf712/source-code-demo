package com.lyf.base.design.behavior;

import com.lyf.base.design.behavior.state.Account;
import com.lyf.base.design.behavior.state.HighAccountState;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liyunfei
 **/
public class StateTest {
    @Test
    public void test_Java_Ref(){
        //Account account = new Account("Lyf",new HighAccountState(this,100));
        Account account = new Account("Lyf",null);
        HighAccountState state = new HighAccountState(account, 1001);
        account.setState(state);
        //System.out.println(state.getAccount());
    
        Assert.assertNotNull(state.getAccount());
        Assert.assertEquals(state.getAccount().getState(),state);
        
        account.writeFile(2);
        account.writeFile(100);
        
        account.leaveMsg("OK...");
    }
}
