package org.example.demo.samples.design.template;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyunfei
 **/
public class TypeHandlerRegister {
    
    private final Configuration configuration;
    
    private final ConcurrentHashMap<Types, Handler> HANDLER_MAP = new ConcurrentHashMap<>();
    
    public TypeHandlerRegister(Configuration configuration) {
        this.configuration = configuration;
        
        register(Types.INTEGER_TYPE, new IntegerTypeHandler());
    }
    
    
    private <T> void register(Types type, Handler<T> handler) {
        HANDLER_MAP.put(type, handler);
    }
}
