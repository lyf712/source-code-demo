package com.lyf.base.design.behavior.observer;

/**
 * @author liyunfei
 **/
public interface Publisher<T> {
    
    boolean publish(T t);
    
    void addSubscriber(Subscriber<T> subscriber);
    
}
