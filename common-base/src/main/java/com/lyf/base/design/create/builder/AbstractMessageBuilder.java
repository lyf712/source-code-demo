package com.lyf.base.design.create.builder;

/**
 * @author liyunfei
 **/
public abstract class AbstractMessageBuilder {
    
    protected AbstractMessage message;
    
    abstract AbstractMessageBuilder buildTitle(Title title);
    
    abstract AbstractMessageBuilder buildSubject(Subject subject);
    
    abstract AbstractMessageBuilder buildContent(Content content);
    
    abstract AbstractMessageBuilder buildUser(Content content);
    
    public AbstractMessage build(){
        return message;
    }
}
