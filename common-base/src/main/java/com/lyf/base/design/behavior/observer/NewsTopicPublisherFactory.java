package com.lyf.base.design.behavior.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author liyunfei
 **/
public class NewsTopicPublisherFactory implements TopicPublisherFactory<News> {
    
    
    // 双map更好
    private final static Map<String/*topic*/, List<Publisher<News>>> PUBLISHERS = new HashMap<>();
    
    
    @Override
    public Publisher<News> create(String topic, String name) {
        List<Publisher<News>> publishers = PUBLISHERS.getOrDefault(topic, new ArrayList<>());
        Publisher<News> publisher = new NewsPublisher(name);
        Optional<Publisher<News>> first = publishers.stream()
            .filter(publisher0 -> ((NewsPublisher) (publisher0)).getPublisher().equals(name))
            .findFirst();
        if (first.isPresent()) {
            publisher = first.get();
        }
        publishers.add(publisher);
        PUBLISHERS.put(topic, publishers);
        return publisher;
    }
    
    @Override
    public Map<String, List<Publisher<News>>> publishers() {
        return PUBLISHERS;
    }
    
    @Override
    public List<Publisher<News>> publishersByTopic(String topic) {
        return PUBLISHERS.get(topic);
    }
}

