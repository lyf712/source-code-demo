package org.example.demo.samples.design.proxy.staticproxy;

import org.example.demo.common.model.UserDO;
import org.example.demo.samples.design.proxy.UserMapper;

/**
 * @author liyunfei
 **/
public class UserMapperImpl implements UserMapper {
    
    @Override
    public boolean insert(UserDO userDO) {
        System.out.println("UserMapper--UserMapperImpl:具体实现的类...");
        return true;
    }
}
