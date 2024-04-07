package org.example.demo.samples.design.proxy.staticproxy;

import org.example.demo.common.model.UserDO;
import org.example.demo.samples.design.proxy.UserMapper;

/**
 * @author liyunfei
 **/
public class UserMapperPlusImpl implements UserMapper {
    
    @Override
    public boolean insert(UserDO userDO) {
        // --
        return false;
    }
}
