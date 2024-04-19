package org.example.demo.samples.design.wrapper;

/**
 * @author liyunfei
 **/
public class PlayerPhoneWrapper implements Phone{
    
    private Phone phone;
    
    public PlayerPhoneWrapper(Phone phone) {
        this.phone = phone;
    }
    
    @Override
    public void receiveMsg(Object msg) {
        phone.receiveMsg(msg);
    }
    
    @Override
    public void sendMsg(Object msg) {
        phone.sendMsg(msg);
    }
    
    private void play(){
        System.out.println("play...");
    }
    
}
