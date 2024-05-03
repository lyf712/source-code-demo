package com.lyf.base.design.behavior.state;

/**
 * @author liyunfei
 **/
public class Account {
    
    private String name;
    
    private BaseAccountState state;
    
    public Account(String name, BaseAccountState state) {
        this.name = name;
        this.state = state;
    }
    
    public void writeFile(int score){
        state.writeFile(score);
    }
    
    public void leaveMsg(String msg) {
        state.leaveMsg(msg);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setState(BaseAccountState state) {
        this.state = state;
    }
    
    public String getName() {
        return name;
    }
    
    public BaseAccountState getState() {
        return state;
    }
    
    @Override
    public String toString() {
        return "Account{" + "name='" + name + '\'' + ", state=" + state + '}';
    }
}
