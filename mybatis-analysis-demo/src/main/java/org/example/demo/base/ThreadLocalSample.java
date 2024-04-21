package org.example.demo.base;

/**
 * @author liyunfei
 **/
public class ThreadLocalSample {
    
    private static final ThreadLocal<Integer> INTEGER = ThreadLocal.withInitial(()-> 1);
    
    
}
