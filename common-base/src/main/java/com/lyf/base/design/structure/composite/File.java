package com.lyf.base.design.structure.composite;

/**
 * @author liyunfei
 **/
public class File extends AbstractElement {
    
    private final String name;
    
    public File(String name) {
        this.name = name;
    }
    
    @Override
    public void add(AbstractElement element) {
        throw new UnsupportedOperationException("file can't support add");
    }
    
    @Override
    public void remove(AbstractElement element) {
        throw new UnsupportedOperationException("file can't remove add");
    }
    
    @Override
    public void display() {
        System.out.printf("element name is %s \n", name);
    }
}
