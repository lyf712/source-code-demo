package org.example.demo.practice;

import org.example.demo.practice.simplecore.excutor.Executor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author liyunfei
 **/
public class ExecutorTest {
    
    private Configuration configuration;
    
    @Before
    public void setUp() {
        configuration = new Configuration();
    }
    
    /**
     * 通过输出情况，查看Executor的执行情况。
     */
    @Test
    public void testExecutorAssemble() {
        // session，最好还是抽象处理，放在Executor，耦合性过高
        execute();
        //Assert.assertEquals(1,);
        configuration.setEnableCache(false);
        execute();
    }
    
    private void execute() {
        Executor executor = configuration.newExecutor();
        String sql = "SELECT * FROM table";
        Object execute = executor.execute(sql);
        
        Object execute1 = executor.execute(sql);
        //Assert.assertEquals(execute, execute1);
    }
    
    
}
