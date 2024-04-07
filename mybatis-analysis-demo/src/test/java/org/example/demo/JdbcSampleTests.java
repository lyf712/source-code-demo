package org.example.demo;

import org.example.demo.common.model.UserDO;
import org.example.demo.samples.JdbcSample;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author liyunfei
 **/
public class JdbcSampleTests {
    
    private final JdbcSample jdbcSample = new JdbcSample();
    
    /**
     * 测试理解，JDBC的基本执行流程
     */
    @Test
    public void testBaseProcess() throws Exception {
        List<UserDO> userDOList = jdbcSample.sample();
        Assert.assertEquals(userDOList.size(), 4);
    }
    
    // 将上述的Sample中的问题进行，源码查看及测试思考 TODO
    
}
