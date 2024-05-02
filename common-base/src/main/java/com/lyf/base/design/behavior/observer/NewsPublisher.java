package com.lyf.base.design.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyunfei
 **/
public class NewsPublisher implements Publisher<News> {
    
    private List<Subscriber<News>> subscriberList = new ArrayList<>();
    
    private final String publisher;
    
    public NewsPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    @Override
    public boolean publish(News news) {
        subscriberList.forEach(newsSubscriber -> {
            System.out.printf("notify::%s", newsSubscriber);
            newsSubscriber.execute(news);
        });
        return false;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    @Override
    public void addSubscriber(Subscriber<News> subscriber) {
        subscriberList.add(subscriber);
    }
}
