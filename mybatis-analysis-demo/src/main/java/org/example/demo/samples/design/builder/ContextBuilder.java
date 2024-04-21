package org.example.demo.samples.design.builder;

/**
 * @author liyunfei
 **/
public class ContextBuilder implements IContextBuilder<ContextBuilder>{
    
    private Context context = new Context();
    
    @Override
    public ContextBuilder id(String id) {
        context.setId(id);
        return this;
    }
    
    @Override
    public ContextBuilder type(Context.Type type) {
        return this;
    }
    
    @Override
    public ContextBuilder fromIp(String ip) {
        return this;
    }
    
    @Override
    public Context build() {
        return context;
    }
}
