package org.example.demo.runnable;

import org.apache.ibatis.logging.LogFactory;
import org.junit.Test;

import java.util.concurrent.Callable;

/**
 * @author liyunfei
 **/
public class RunnableTest {
    
    
    @Test
    public void test(){
        new RunnableService().test(RunnableService::demo1);
        new RunnableService().test(()->{});
        RunnableService runnableService = new RunnableService();
        new RunnableService().test(runnableService::demo2);
        new RunnableService().testCallbale(RunnableService::demo5);
        
//        new RunnableService().test(RunnableService.demo1());
//        new RunnableService().test(new RunnableService().demo2());
 ;
//        Callable<>
//        new RunnableService().testFun(RunnableService::demo1,"ok");
//        new RunnableService().testS(RunnableService::demo1);
        
        //
        //new RunnableService().test( new RunnableService().demo2());
//        {
//            System.out.println("ok");
//        }
        //new RunnableService().test();//new RunnableService().demo2()
        
    }
}
