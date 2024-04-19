package org.example.demo.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyunfei
 **/
public class CacheMap {
    
    private static final Map<String,String> cache = new ConcurrentHashMap<>();
    
    void put(String key,String val){
        cache.computeIfAbsent(key,k->{
            return val;
        });
    }
    
}
