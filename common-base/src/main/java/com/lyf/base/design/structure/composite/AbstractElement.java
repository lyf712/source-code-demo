package com.lyf.base.design.structure.composite;

/**
 * @author liyunfei
 **/
public abstract class AbstractElement {
    
    abstract void add(AbstractElement element);
    
    abstract void remove(AbstractElement element);
    
    abstract void display();
    
}
