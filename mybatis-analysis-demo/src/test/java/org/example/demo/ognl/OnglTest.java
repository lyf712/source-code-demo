package org.example.demo.ognl;

import org.apache.ibatis.ognl.OgnlException;
import org.example.demo.samples.ognl.OGNLSample;
import org.junit.Test;

/**
 * @author liyunfei
 **/
public class OnglTest {
    
    @Test
    public void test() throws OgnlException {
        new OGNLSample().sample();
    }
}
