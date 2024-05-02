package com.lyf.base.design.create.builder;

/**
 * @author liyunfei
 **/
public abstract class AbstractMessage {
    
    protected Title title;
    protected Subject subject;
    protected User user;
    protected Content content;
    
    public Title getTitle() {
        return title;
    }
    
    public void setTitle(Title title) {
        this.title = title;
    }
    
    public Subject getSubject() {
        return subject;
    }
    
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Content getContent() {
        return content;
    }
    
    public void setContent(Content content) {
        this.content = content;
    }
}
