package com.lyf.base.design.behavior.chain;

/**
 * @author liyunfei
 **/
public interface Handler <T extends BaseRequest,R>{
    R handle(T request);
}
