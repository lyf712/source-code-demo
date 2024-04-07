package org.example.demo.samples.design.proxy.staticproxy;

import org.example.demo.common.model.UserDO;
import org.example.demo.samples.design.proxy.UserMapper;

/**
 * @author liyunfei
 **/
public class ProxyUserMapper implements UserMapper {
    
    /**
     * 代理目标对象
     */
    private UserMapper proxyTarget;
    
    public ProxyUserMapper(UserMapper proxyTarget) {
        this.proxyTarget = proxyTarget;
    }
    
    
    public void beforeHandle(){}
    
    public void afterHandle(){}
    
    @Override
    public boolean insert(UserDO userDO) {
        // 还可以基于 此 在前后 做动作
        // checkParam等
        beforeHandle();
        boolean rs = proxyTarget.insert(userDO);
        // 后置
        afterHandle();
        return rs;
    }
}
