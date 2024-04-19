package org.example.demo.samples.design.wrapper;

/**
 * @author liyunfei
 **/
public class CommonPhone implements Phone {
    
    @Override
    public void receiveMsg(Object msg) {
        System.out.println("获取信息:" + msg);
    }
    
    @Override
    public void sendMsg(Object msg) {
        System.out.println("发送信息:" + msg);
    }
}
