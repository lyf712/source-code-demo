package com.lyf.base.design.create;

import com.lyf.base.design.create.builder.AbstractMessageBuilder;
import com.lyf.base.design.create.builder.Title;
import com.lyf.base.design.create.builder.WxMessage;
import com.lyf.base.design.create.builder.WxMessageBuilder;
import com.lyf.base.design.create.builder.context.UserContext;
import org.junit.Test;

import javax.xml.parsers.DocumentBuilder;

/**
 * @author liyunfei
 **/
public class BuilderTest {
    @Test
    public void test(){
        WxMessageBuilder builder = new WxMessageBuilder();
        WxMessage message = (WxMessage) builder.buildTitle(new Title()).build();
    
        UserContext context = new UserContext.Builder()
            .age(1)
            .build();
        
        UserContext.newBuilder().age(1).build();
        
    }
    
    @Test
    public void test_2(){
        // 父子类的抽象
        StringBuilder stringBuilder = new StringBuilder();
        
        //
       // DocumentBuilder
       
       
    }
}
