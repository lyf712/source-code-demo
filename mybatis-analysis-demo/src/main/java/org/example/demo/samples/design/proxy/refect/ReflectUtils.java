package org.example.demo.samples.design.proxy.refect;

import org.example.demo.common.model.UserDO;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 对比理解反射： 通过对象反过来获取类的类型。 需要对类的组成（类名，属性，方法，对象等概念比较熟悉：JVM的书值得反复看）！！
 *
 * @author liyunfei
 **/
public class ReflectUtils {
    
    
    public static Map<String, String> diffObjectV1(UserDO oldUser, UserDO newUser) {
        if (oldUser == null || newUser == null) {
            throw new IllegalArgumentException("");
        }
        Map<String, String> map = new HashMap<>();
        if (oldUser.getName() != null && newUser.getName() != null && !oldUser.getName()
            .equals(newUser.getName())) {
            map.put("name", String.format("from %s to %s", oldUser.getName(), newUser.getName()));
        }
        return map;
    }
    
    
    public static Map<String, String> diffObjectV2(Object oldObj, Object newObj) {
        Class<?> oldObjClass = oldObj.getClass();
        Class<?> newObjClass = newObj.getClass();
        if (!oldObjClass.equals(newObjClass)) {
            throw new IllegalArgumentException("");
        }
        // 获取filed，通过filed类型反过来拿值，
        Field[] declaredFields = oldObjClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            
            try {
                // 通过对象反过来 拿值
                Object oldVal = declaredField.get(oldObj);
                Object newVal = declaredField.get(newObj);
                
                // 做处理----
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        
        
        // 方法--
        /**
         * getDeclaredMethod：
         *
         * 该方法用于获取类中声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
         * 如果指定的方法不存在，则会抛出 NoSuchMethodException 异常。
         * 通常用于获取当前类中定义的方法，而不是从父类或接口继承的方法。
         * getMethod：
         *
         * 该方法用于获取类中的公共方法，包括从父类和接口继承的公共方法。
         * 如果指定的方法不存在或不是公共方法，则会抛出 NoSuchMethodException 异常。
         * 通常用于获取在对象上调用的公共方法，因为公共方法对外部调用者可见。
         */
        Method[] declaredMethods = oldObjClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            declaredMethod.setAccessible(true);
            try {
                // args..
                declaredMethod.invoke(oldObj);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    
        return null;
    }
    
    
}
