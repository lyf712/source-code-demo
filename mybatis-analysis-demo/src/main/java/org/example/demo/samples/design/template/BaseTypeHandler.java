package org.example.demo.samples.design.template;

//import java.util.logging.Handler;
//import java.util.logging.LogRecord;

/**
 * @author liyunfei
 **/
public abstract class BaseTypeHandler<T> implements Handler<T> {
    
    abstract void checkParam(Object...params);
    
    abstract T transfer(Object...params);
    
    abstract void report(Object...params);
    
    @Override
    public final T handle(Object... param) {
        checkParam(param);
        T rs = transfer(param);
        report(param);
        return rs;
    }
}
