package org.example.demo.samples.design.wrapper;

/**
 * @author liyunfei
 **/
public interface Phone {
    
    /**
     * 接受信息
     * @param msg msg
     */
    void receiveMsg(Object msg);
    
    /**
     * 发生信息
     * @param msg msg
     */
    void sendMsg(Object msg);
    
    
}
