package org.example.demo.samples.design.adapter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liyunfei
 **/
public class Client {
    
    public static void main(String[] args)
        throws InvocationTargetException, IllegalAccessException, NoSuchMethodException,
        InstantiationException {
        //        ITarget target = new Adapter(new Adaptee());
        //        target.handle();
        Class<?>[] classes = new Class[] {Handler1.class, Adapter.class};
        for (Class<?> aClass : classes) {
            executeHandle(aClass);
        }
    }
    
    static void executeHandle(Class<?> clazz)
        throws InvocationTargetException, IllegalAccessException, NoSuchMethodException,
        InstantiationException {
        Object o;
        if ("Adapter".equals(clazz.getSimpleName())) {
            o = clazz.getConstructor(Adaptee.class).newInstance(new Adaptee());
        } else {
            o = clazz.getConstructor().newInstance();
        }
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            declaredMethod.setAccessible(true);
            if ("handle".equals(declaredMethod.getName())) {
                declaredMethod.invoke(o);
            }
        }
    }
}
