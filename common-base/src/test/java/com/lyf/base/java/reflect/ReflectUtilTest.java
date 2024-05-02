package com.lyf.base.java.reflect;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Target;
import java.util.List;

/**
 * @author liyunfei
 **/
public class ReflectUtilTest {
    
    @Test
    public void test_1(){
        List<Class<?>> implClassByInterface =
            ReflectUtil.getImplClassByInterface(MapperInterface.class);
        Assert.assertNotNull(implClassByInterface);
        Assert.assertEquals(2,implClassByInterface.size());
    }
    
    @Test
    public void test_2(){
        Object haierTvFactory = ReflectUtil.getBean("com.lyf.base.design.create.factory.HaierTvFactory");
    }
}
