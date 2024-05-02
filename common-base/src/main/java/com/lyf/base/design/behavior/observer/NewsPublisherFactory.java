package com.lyf.base.design.behavior.observer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyunfei
 **/
public class NewsPublisherFactory implements PublisherFactory<News> {
    
    private final static Map<String, Publisher<News>> PUBLISHERS = new HashMap<>();
    
    private final static class Holder{private final static NewsPublisherFactory I = new NewsPublisherFactory();}
    
    private NewsPublisherFactory() {
    }
    
    public static NewsPublisherFactory getInstance(){
        return Holder.I;
    }
    
    @Override
    public Publisher<News> create(String name) {
        return PUBLISHERS.getOrDefault(name, new NewsPublisher(name));
    }
    
    @Override
    public Map<String, Publisher<News>> publishers() {
        return PUBLISHERS;
    }
}
