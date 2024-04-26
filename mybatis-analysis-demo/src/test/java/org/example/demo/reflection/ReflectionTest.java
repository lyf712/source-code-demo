package org.example.demo.reflection;

import org.example.demo.base.reflection.IService;
import org.example.demo.base.reflection.SampleServiceImpl;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author liyunfei
 **/
public class ReflectionTest {
    
    // 根据类信息，反过来执行
    
    /**
     * 通过调试进行查看，较快
     */
    @Test
    public void test() {
        
        // 类（接口）信息
        IService iService = new SampleServiceImpl("test");
        
        Class<?> clazz = IService.class;
        System.out.println(clazz);
        
        clazz = iService.getClass();
        System.out.println(clazz);
        Class<?>[] interfaces = clazz.getInterfaces();
        Type[] genericInterfaces = clazz.getGenericInterfaces();
    
        try {
            Constructor<?> constructor = clazz.getConstructor(String.class);
            constructor.setAccessible(true);
            Object test2 = constructor.newInstance("test2");
            ((IService) test2).execute("hhhhh");
        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    
        try {
            Method execute = clazz.getMethod("execute", String[].class);
            execute.setAccessible(true);
            execute.invoke(iService, (Object) new String[] {"ok"});
        } catch (NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    
}
