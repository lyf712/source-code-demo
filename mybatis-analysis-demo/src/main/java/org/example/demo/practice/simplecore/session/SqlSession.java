package org.example.demo.practice.simplecore.session;

/**
 * @author liyunfei
 **/
public interface SqlSession {
    
    Object executeSql(String sql,ExecuteType type);
    
    enum ExecuteType {
        SIMPLE, BATCH
    }
}
