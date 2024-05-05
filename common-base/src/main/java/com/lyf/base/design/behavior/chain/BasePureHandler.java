package com.lyf.base.design.behavior.chain;

/**
 * 纯的责任链。
 *
 * @author liyunfei
 **/
public abstract class BasePureHandler<T extends BaseRequest, R> implements Handler<T, R> {
    
    protected BasePureHandler<T, R> next;
    
    public void setNext(BasePureHandler<T, R> next) {
        this.next = next;
    }
    
    @Override
    public R handle(T request) {
        if (canHandle(request)) {
            return this.handle0(request);
        } else {
            if (next != null) {
               return this.next.handle(request);
            }
        }
        throw  new RuntimeException("无法处理...");
        //return null;
    }
    
    /**
     *
     * @param request
     * @return
     */
    abstract boolean canHandle(T request);
    
    /**
     *
     * @param request
     * @return
     */
    abstract R handle0(T request);
}
