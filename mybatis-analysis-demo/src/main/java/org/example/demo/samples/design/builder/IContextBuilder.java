package org.example.demo.samples.design.builder;

/**
 * @author liyunfei
 **/
public interface IContextBuilder<T> {
    
    T id(String id);
    
    T type(Context.Type type);
    
    T fromIp(String ip);
    
    // ....
    
    Context build();
}
