package org.example.demo.result;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.demo.common.mapper.UserMapper;
import org.example.demo.common.model.AliasUser;
import org.example.demo.samples.myabtis.docs.SqlSessionFactoryRegistry;
import org.example.demo.samples.myabtis.docs.SqlSessionFactoryTypeEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyunfei
 **/
public class ResultHandlerTest {
    
    private SqlSessionFactory sqlSessionFactory;
    
    private SqlSession defaultSession;
    
    
    @Before
    public void setUp() {
        sqlSessionFactory =
            SqlSessionFactoryRegistry.getByType(SqlSessionFactoryTypeEnum.XML_CONFIG);
        
        defaultSession = sqlSessionFactory.openSession();
    }
    
    @Test
    public void test() {
        UserMapper mapper = defaultSession.getMapper(UserMapper.class);
        // 非void返回，具有 resultMap的返回值
        mapper.queryAliasUsersByHandler(new ResultHandler<AliasUser>() {
            @Override
            public void handleResult(ResultContext<? extends AliasUser> resultContext) {
                System.out.println(resultContext);
                System.out.println(resultContext.getResultCount() + ":::>>>>");
            }
        });
        
        //defaultSession.getConfiguration().
//        mapper.queryAliasUsersByHandler2(new ResultHandler<AliasUser>() {
//            @Override
//            public void handleResult(ResultContext<? extends AliasUser> resultContext) {
//                //                System.out.println(resultContext);
//                //                System.out.println(resultContext.getResultCount()+":::>>2222>>");
//                System.out.println(resultContext.getResultCount() + ":>>>>");
//                AliasUser resultObject = resultContext.getResultObject();
//                System.out.println(resultObject);
//            }
//        });
        
        
        mapper.queryAliasUsersByHandler2(new TransferResultHandler("order-1"));
        mapper.queryAliasUsersByHandler2(new TransferResultHandler("order-2"));
        
    }
    
    public static class TransferResultHandler implements ResultHandler<AliasUser> {
        
        private String topic;
        
        public TransferResultHandler(String topic) {
            this.topic = topic;
        }
        
        @Override
        public void handleResult(ResultContext<? extends AliasUser> resultContext) {
            // 转发至 topic
            System.out.printf("send %s to topic (%s)", resultContext.getResultObject(), topic);
        }
    }
    
    
}
