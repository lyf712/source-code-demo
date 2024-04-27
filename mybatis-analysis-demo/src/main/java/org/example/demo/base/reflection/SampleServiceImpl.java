package org.example.demo.base.reflection;

import java.util.Arrays;

/**
 * @author liyunfei
 **/
public class SampleServiceImpl implements IService,CycleLife{
    
    private final String name;
    
    private int state = 0;
    
    public SampleServiceImpl(String name) {
        this.name = name;
    }
    
    @Override
    public void execute(String... args) {
        System.out.println(Arrays.toString(args));
    }
    
    @Override
    public void close() {
    
    }
    
    @Override
    public int state() {
        return getState();
    }
    
    public String getName() {
        return name;
    }
    
    public int getState() {
        return state;
    }
    
    public void setState(int state) {
        this.state = state;
    }
}
