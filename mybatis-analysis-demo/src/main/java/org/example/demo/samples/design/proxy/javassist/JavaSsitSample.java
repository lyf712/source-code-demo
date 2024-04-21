package org.example.demo.samples.design.proxy.javassist;

import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.NotFoundException;

/**
 * @author liyunfei
 **/
public class JavaSsitSample {
    void sample() throws NotFoundException, CannotCompileException, InstantiationException,
        IllegalAccessException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.getCtClass("org.example.demo.samples.design.proxy.javassist.UserService");
       
       
        // 生成--class..
        Class<?> aClass = ctClass.toClass();
        Object o = aClass.newInstance();
        
    }
}
