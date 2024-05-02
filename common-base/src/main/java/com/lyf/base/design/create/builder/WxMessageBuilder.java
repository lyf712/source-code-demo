package com.lyf.base.design.create.builder;

/**
 * @author liyunfei
 **/
public class WxMessageBuilder extends AbstractMessageBuilder{
    
    private final WxMessage wxMessage = new WxMessage();
    
    public WxMessageBuilder() {
    }
    
    @Override
    public AbstractMessageBuilder buildTitle(Title title) {
        wxMessage.setTitle(title);
        return this;
    }
    
    @Override
    public AbstractMessageBuilder buildSubject(Subject subject) {
        wxMessage.setSubject(subject);
        return this;
    }
    
    @Override
    public AbstractMessageBuilder buildContent(Content content) {
        wxMessage.setContent(content);
        return this;
    }
    
    @Override
    public AbstractMessageBuilder buildUser(Content content) {
        wxMessage.setContent(content);
        return this;
    }
}
