package org.example.demo.samples.myabtis.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Statement;
import java.util.List;
import java.util.Properties;

/**
 * @author liyunfei
 **/
@Intercepts(value = {
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class,Object.class,
        RowBounds.class, ResultHandler.class}),
    @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = Statement.class)})
public class MySamplePlugin2 implements Interceptor {
    
    private String param;
    
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println(param + "::::===测试222>>>>总数为：BEFORE");
        Object proceed = invocation.proceed();
        System.out.println(param + "::::===测试222>>>>总数为：" + ((List) proceed).size());
        return proceed;
    }
    
    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }
    
    @Override
    public void setProperties(Properties properties) {
        param = properties.getProperty("test");
        Interceptor.super.setProperties(properties);
    }
}
