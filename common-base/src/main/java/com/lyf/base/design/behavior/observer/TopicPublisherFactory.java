package com.lyf.base.design.behavior.observer;

import java.util.List;
import java.util.Map;

/**
 * @author liyunfei
 **/
public interface TopicPublisherFactory<T> {
    
    Publisher<T> create(String topic, String name);
    
    Map<String, List<Publisher<T>>> publishers();
    
    List<Publisher<T>> publishersByTopic(String topic);
    
}
