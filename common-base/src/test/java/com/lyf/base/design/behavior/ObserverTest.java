package com.lyf.base.design.behavior;

import com.lyf.base.design.behavior.observer.News;
import com.lyf.base.design.behavior.observer.NewsPublisher;
import com.lyf.base.design.behavior.observer.NewsSubscriber;
import com.lyf.base.design.behavior.observer.Publisher;
import org.junit.Test;

/**
 * @author liyunfei
 **/
public class ObserverTest {
    @Test
    public void test(){
        Publisher<News> newsPublisher = new NewsPublisher("newPublisher-1");
        newsPublisher.addSubscriber(new NewsSubscriber("subscriber-1"));
        newsPublisher.addSubscriber(new NewsSubscriber("subscriber-2"));
        
        // News Builder进行构建xxx
        newsPublisher.publish(new News());
    }
}
