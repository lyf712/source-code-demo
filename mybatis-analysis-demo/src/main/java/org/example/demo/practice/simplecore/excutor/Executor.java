package org.example.demo.practice.simplecore.excutor;

/**
 * @author liyunfei
 **/
public interface Executor<IN,OUT> {
    
    /**
     * 执行
     * @param input
     * @return
     */
    OUT execute(IN input);
    
    ExecutorType type();
}
