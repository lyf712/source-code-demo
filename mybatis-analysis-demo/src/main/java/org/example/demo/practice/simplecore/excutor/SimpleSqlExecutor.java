package org.example.demo.practice.simplecore.excutor;

import org.example.demo.practice.simplecore.session.DefaultSqlSession;
import org.example.demo.practice.simplecore.session.SqlSession;

/**
 * @author liyunfei
 **/
public class SimpleSqlExecutor extends BaseSqlExecutor {
    
    public SimpleSqlExecutor() {
        super(null);
    }
    
    public SimpleSqlExecutor(Executor<String, Object> delegate) {
        super(delegate);
    }
    
    @Override
    Object doExecute(String sql) {
        System.out.println("SIMPLE执行器执行：");
        Object rs;
        if (delegate != null) {
            rs = delegate.execute(sql);
        } else {
            rs = session.executeSql(sql, SqlSession.ExecuteType.SIMPLE);
        }
        return rs;
    }
    
    @Override
    public ExecutorType type() {
        return ExecutorType.SQL_SIMPLE;
    }
}
