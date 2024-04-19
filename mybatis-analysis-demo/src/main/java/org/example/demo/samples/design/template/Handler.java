package org.example.demo.samples.design.template;

/**
 * @author liyunfei
 **/
public interface Handler<T>{
    
    /**
     *
     * @param param 处理参数
     * @return
     */
    T handle(Object... param);
    
}
