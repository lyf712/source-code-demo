package org.example.demo.practice.simplecore.session;

import java.util.Random;

/**
 * @author liyunfei
 **/
public class DefaultSqlSession implements SqlSession {
    
    // 简单测试用于，不考虑线程
    
    private int callCount = 0;
    
    @Override
    public Object executeSql(String sql, SqlSession.ExecuteType executeType) {
        System.out.printf("执行SQL：%s %s\n", sql, executeType);
        callCount++;
        return new Random().nextInt();
    }
    
    public enum ExecuteType {
        SIMPLE, BATCH
    }
    
    public int getCallCount() {
        return callCount;
    }
}
