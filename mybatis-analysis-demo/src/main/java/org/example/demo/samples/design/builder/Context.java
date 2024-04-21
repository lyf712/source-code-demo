package org.example.demo.samples.design.builder;

import lombok.Data;

/**
 * @author liyunfei
 **/
@Data
public class Context {
    
    private String id;
    
    private Type type;
    
    private String fromIp;
    
    private String url;
    
    enum Type{
        /**
         *
         */
        HTTP,
        /**
         *
         */
        DUBBO
    }
    
}
