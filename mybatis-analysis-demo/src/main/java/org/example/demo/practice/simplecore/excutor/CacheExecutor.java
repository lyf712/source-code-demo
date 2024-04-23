package org.example.demo.practice.simplecore.excutor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyunfei
 **/
public class CacheExecutor implements Executor<Object, Object> {
    
    private final Map<Object, Object> cache = new ConcurrentHashMap<>();
    
    private final Executor<Object, Object> delegate;
    
    public CacheExecutor(Executor<Object, Object> delegate) {
        this.delegate = delegate;
    }
    
    @Override
    public Object execute(Object input) {
        System.out.println("缓存Executor执行");
        return cache.computeIfAbsent(input, key -> delegate.execute(input));
    }
    
    @Override
    public ExecutorType type() {
        return ExecutorType.CACHE;
    }
    
    public Object getDataFromCache(String key) {
        return cache.getOrDefault(key, cache.computeIfAbsent(key, keyo -> delegate.execute(key)));
    }
}
