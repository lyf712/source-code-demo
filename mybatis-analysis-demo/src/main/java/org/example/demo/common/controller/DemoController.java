package org.example.demo.common.controller;

import org.example.demo.common.mapper.UserMapperBootVersion;
import org.example.demo.common.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liyunfei
 **/
@RestController
@RequestMapping("/demo")
public class DemoController {
    
    @Autowired
    private UserMapperBootVersion userMapper;
    
    @RequestMapping("/")
    public Object index() {
        UserDO userParam = new UserDO();
        userParam.setSchoolName("Sunny School");
        List<UserDO> userList = userMapper.queryUserBySchoolName(userParam);
        for (UserDO user : userList) {
            System.out.println("name : " + user.getName() + " ;  email : " + user.getEmail());
        }
        return userList;
    }
    
    
}
