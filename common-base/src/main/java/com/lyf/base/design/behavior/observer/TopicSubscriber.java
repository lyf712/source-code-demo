package com.lyf.base.design.behavior.observer;

/**
 * @author liyunfei
 **/
public interface TopicSubscriber <T1/*Type*/,T2/*Topic:可根据类型，也可根据。。。*/>{
    
    boolean subscribe(T1 type,T2 topic);
    
    void execute(T1 obj);
    
}
