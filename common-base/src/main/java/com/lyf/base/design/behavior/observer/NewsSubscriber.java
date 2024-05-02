package com.lyf.base.design.behavior.observer;

/**
 * @author liyunfei
 **/
public class NewsSubscriber implements Subscriber<News>{
    
    private final NewsPublisherFactory factory = NewsPublisherFactory.getInstance();
    
    private final String name;
    
    public NewsSubscriber(String name) {
        this.name = name;
    }
    
    @Override
    public boolean subscribe(News news) {
        factory.publishers().values().forEach(newsPublisher -> {
            newsPublisher.addSubscriber(this);
        });
        return true;
    }
    
    @Override
    public String toString() {
        return "NewsSubscriber{" + "name='" + name + '\'' + '}';
    }
    
//    public String getName() {
//        return name;
//    }
    
    @Override
    public void execute(Object obj) {
        System.out.println("进行阅读News::"+obj);
    }
}
