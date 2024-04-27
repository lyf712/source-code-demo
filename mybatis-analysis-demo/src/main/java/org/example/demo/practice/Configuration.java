package org.example.demo.practice;

import org.example.demo.practice.simplecore.excutor.BatchSqlExecutor;
import org.example.demo.practice.simplecore.excutor.CacheExecutor;
import org.example.demo.practice.simplecore.excutor.Executor;
import org.example.demo.practice.simplecore.excutor.ExecutorType;
import org.example.demo.practice.simplecore.excutor.SimpleSqlExecutor;

/**
 * @author liyunfei
 **/
public class Configuration {
    
    private  boolean enableCache = true;
    
    private  ExecutorType executorType = ExecutorType.SQL_SIMPLE;
    
    
    public Executor newExecutor(){
        Executor executor;
        if(executorType==ExecutorType.SQL_SIMPLE){
            executor = new SimpleSqlExecutor();
        }else if (executorType==ExecutorType.SQL_BATCH){
            executor = new BatchSqlExecutor();
        }else {
            // 兜底
            executor = new SimpleSqlExecutor();
        }
        if(enableCache){
            executor = new CacheExecutor(executor);
        }
        return executor;
    }
    
    public boolean isEnableCache() {
        return enableCache;
    }
    
    public void setEnableCache(boolean enableCache) {
        this.enableCache = enableCache;
    }
    
    public ExecutorType getExecutorType() {
        return executorType;
    }
    
    public void setExecutorType(ExecutorType executorType) {
        this.executorType = executorType;
    }
}
