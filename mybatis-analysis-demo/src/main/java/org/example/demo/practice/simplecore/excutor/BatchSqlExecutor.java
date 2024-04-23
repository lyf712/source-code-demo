package org.example.demo.practice.simplecore.excutor;

import org.example.demo.practice.simplecore.session.SqlSession;

/**
 * @author liyunfei
 **/
public class BatchSqlExecutor extends BaseSqlExecutor {
    
    public BatchSqlExecutor() {
        super(null);
    }
    
    public BatchSqlExecutor(Executor<String, Object> delegate) {
        super(delegate);
    }
    
    @Override
    Object doExecute(String sql) {
        System.out.println("BATCH执行器执行：");
        Object rs;
        if (delegate != null) {
            rs = delegate.execute(sql);
        } else {
            rs = session.executeSql(sql, SqlSession.ExecuteType.BATCH);
        }
        return rs;
    }
    
    @Override
    public ExecutorType type() {
        return null;
    }
}
