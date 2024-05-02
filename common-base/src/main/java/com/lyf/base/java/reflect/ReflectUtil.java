package com.lyf.base.java.reflect;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author liyunfei
 **/
public class ReflectUtil {
    
    
    /**
     * spring-context:ClassPathScanningCandidateComponentProvider
     *
     * @param interfaceClass
     * @return
     */
    public static List<Class<?>> getImplClassByInterface(Class<?> interfaceClass) {
        List<Class<?>> implClasses = new ArrayList<>();
        
        // package_name 需要同一个包下面
        String packageName = interfaceClass.getPackage().getName();
        System.out.printf("packageName:%s\n", packageName);
        String packageNamePath = packageName.replace(".", "/");
        
        File file = new File(
            Objects.requireNonNull(ReflectUtil.class.getClassLoader().getResource(packageNamePath))
                .getFile());
        
        File[] classFiles = file.listFiles();
        
        assert classFiles != null;
        
        for (File classFile : classFiles) {
            String className = packageName + '.' + classFile.getName().replace(".class", "");
            System.out.printf("className:%s\n", className);
            Class<?> clazz = null;
            try {
                clazz = Class.forName(className);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            
            //interfaceClass.isAssignableFrom(clazz)
            if (interfaceClass.isAssignableFrom(clazz) && !interfaceClass.equals(clazz)
                && !clazz.isInterface()) {
                implClasses.add(clazz);
            }
            
        }
        
        return implClasses;
    }
    
    public static Object getBean(String className) {
        try {
            return Class.forName(className).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    
}
