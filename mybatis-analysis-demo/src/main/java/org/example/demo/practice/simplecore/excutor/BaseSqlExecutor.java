package org.example.demo.practice.simplecore.excutor;

import org.example.demo.practice.simplecore.session.DefaultSqlSession;
import org.example.demo.practice.simplecore.session.SqlSession;

/**
 * @author liyunfei
 **/
public abstract class BaseSqlExecutor implements Executor<String/*sql语句*/, Object/*处理结果*/> {
    
    protected final Executor<String, Object> delegate;
    
    // 简化设计：---应该传入---
    
    protected SqlSession session = new DefaultSqlSession();
    
    public BaseSqlExecutor(Executor<String, Object> delegate) {
        this.delegate = delegate;
    }
    
    @Override
    public Object execute(String input) {
        checkSql(input);
        return doExecute(input);
    }
    
    public DefaultSqlSession getSession() {
        return (DefaultSqlSession) session;
    }
    
    abstract Object doExecute(String sql);
    
    private void checkSql(String sql) {
        if (sql == null || sql.isEmpty()) {
            throw new IllegalArgumentException("SQL Error " + sql);
        }
    }
    
}
