package com.lyf.base.design.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyunfei
 **/
public class Folder extends AbstractElement {
    
    private final List<AbstractElement> list = new ArrayList<>();
    
    private final String name;
    
    public Folder(String name) {
        this.name = name;
    }
    
    @Override
    public void add(AbstractElement element) {
        list.add(element);
    }
    
    @Override
    public void remove(AbstractElement element) {
        list.remove(element);
    }
    
    @Override
    public void display() {
        //        list.forEach(element -> {
        //
        //        });
        
        //
        
        //            if(element instanceof File){
        //                element.display();
        //            }
        
        System.out.printf("folder:%s \n", name);
        list.forEach(AbstractElement::display);
        
    }
}
