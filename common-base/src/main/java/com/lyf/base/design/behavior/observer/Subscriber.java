package com.lyf.base.design.behavior.observer;

/**
 * @author liyunfei
 **/
public interface Subscriber<T>{
    
    boolean subscribe(T t);
    
    void execute(Object obj);
}
