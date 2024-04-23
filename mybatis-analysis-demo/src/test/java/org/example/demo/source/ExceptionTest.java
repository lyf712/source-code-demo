package org.example.demo.source;

import org.junit.Test;

/**
 * 异常的理解
 *
 * @author liyunfei
 **/
public class ExceptionTest {
    
    
    @Test
    public void test() {
        try {
            exception1();
        } catch (Exception e) {
            System.out.printf("%s\n", e);
        }
    
        try {
            exception2();
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.printf("%s\n",e);
        }
    }
    
    public void exception1() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public void exception2() throws Exception{
  
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    
    }
    
}
