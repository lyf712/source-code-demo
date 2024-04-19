package org.example.demo.samples.design.adapter;

/**
 * @author liyunfei
 **/
public class Adapter implements ITarget{
    
    private final Adaptee adaptee;
    
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    
    @Override
    public void handle() {
        System.out.println("适配后的处理");
        adaptee.work();
    }
}
