package org.example.demo.samples.cache;

/**
 * @author liyunfei
 **/
public interface Cache {
    
    void put(Object key, Object val);
    
    Object get(Object key);
}
