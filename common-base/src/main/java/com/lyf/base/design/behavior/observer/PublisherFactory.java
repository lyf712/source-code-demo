package com.lyf.base.design.behavior.observer;

import java.util.Map;

/**
 * @author liyunfei
 **/
public interface PublisherFactory<T> {
    
    Publisher<T> create(String name);
    
    Map<String,Publisher<T>> publishers();
    
}
