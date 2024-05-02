package com.lyf.base.design.behavior.observer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liyunfei
 **/
public class NewTopicSubscriber implements TopicSubscriber<News,String>{
    
    private final static Map<String, List<Publisher<News>>> PUBLISHERS = new HashMap<>();
    
    private final NewsPublisherFactory factory = NewsPublisherFactory.getInstance();
    
    @Override
    public boolean subscribe(News type, String topic) {
        ///factory.create(topic);
        
        return true;
    }
    
    @Override
    public void execute(News obj) {
    
    }
}
