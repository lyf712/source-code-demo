package org.example.demo.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyunfei
 **/
public class CacheUtil {
    
    private final static Map<String, Object> localCache = new ConcurrentHashMap<>();
    
    public static class Holder{private static final CacheUtil I = new CacheUtil();}
    
    public static CacheUtil getInstance(){return Holder.I;}
    
    public void put(String key,String val){
        localCache.put(key,val);
    }
    
    public Object get(String key){
        return localCache.get(key);
    }
}
