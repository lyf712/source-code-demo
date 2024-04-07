package org.example.demo;

import org.example.demo.common.model.UserDO;
import org.example.demo.samples.myabtis.MybatisBaseSample;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author liyunfei
 **/
public class MybatisSampleTests {

    private final MybatisBaseSample mybatisBaseSample = new MybatisBaseSample();
    
    @Test
    public void testBaseUse(){
        try {
            /**
             * :20:12.512 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Opening JDBC Connection
             * 00:20:14.261 [main] DEBUG org.apache.ibatis.datasource.pooled.PooledDataSource - Created connection 1678046232.
             * 00:20:14.261 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Setting autocommit to false on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@6404f418]
             * 00:20:14.265 [main] DEBUG org.example.demo.common.mapper.UserMapper.queryUserBySchoolName - ==>  Preparing: SELECT * FROM `user` WHERE school_name = ?
             * 00:20:14.293 [main] DEBUG org.example.demo.common.mapper.UserMapper.queryUserBySchoolName - ==> Parameters: Sunny School(String)
             * 00:20:14.332 [main] DEBUG org.example.demo.common.mapper.UserMapper.queryUserBySchoolName - <==      Total: 4
             * name : 易哥 ;  email : yeecode@sample.com
             * name : 杰克 ;  email : jack@sample.com
             * name : 王小壮 ;  email : wxiaozhuang@sample.com
             * name : 李二壮 ;  email : lerzhuang@sample.com
             * 00:20:14.334 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Resetting autocommit to true on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@6404f418]
             * 00:20:14.336 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Closing JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@6404f418]
             * 00:20:14.337 [main] DEBUG org.apache.ibatis.datasource.pooled.PooledDataSource - Returned connection 1678046232 to pool.
             */
            List<UserDO> userDOList = mybatisBaseSample.sample();
            Assert.assertEquals(userDOList.size(), 4);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    
    }
    
}
