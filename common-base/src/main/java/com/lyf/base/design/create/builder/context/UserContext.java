package com.lyf.base.design.create.builder.context;

import com.lyf.base.design.create.builder.User;

import java.util.Properties;

/**
 * @author liyunfei
 **/
public class UserContext implements Context{
    
    private Integer age;
    
    private Long time;
    
    
    
    @Override
    public void id(String id) {
    
    }
    
    @Override
    public void user(String user) {
    
    }
    
    @Override
    public void props(Properties props) {
    
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public static Builder newBuilder(){
        return new Builder();
    }
    
    public static class Builder{
       
        private UserContext context = new UserContext();
        
        // con..
        public Builder age(Integer age){
            context.setAge(age);
            return this;
        }
        
        public UserContext build(){return context;}
        
    }
}
