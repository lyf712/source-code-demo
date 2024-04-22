package org.example.demo.runnable;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author liyunfei
 **/
public class RunnableService {
    
    void test(Runnable runnable){
          runnable.run();
    }
    
    void testCallbale(Callable<Object> callable){
        try {
            Object call = callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    void testFun(Consumer<Object> consumer,Object arg){
        consumer.accept(arg);
    }
    
//    void testS(Supplier<Void> supplier){
//        supplier.get();
//    }
    
    static void demo1(){
        System.out.println("demo1 执行----");
    }
//
//    static Void demo5(){
//        System.out.println("demo1 执行----");
//        return null;
//    }
    
    static Object demo3(){
        System.out.println("demo3 执行----");
        return null;
    }
    
    void demo2(){
        System.out.println("demo2 执行----");
    }
    
    Object demo4(){
        System.out.println("demo4 执行----");
        return new Runnable() {
            @Override
            public void run() {
            
            }
        };
    }
    
    static Void demo5(){
        return null;
    }
}
