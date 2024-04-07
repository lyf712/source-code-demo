package org.example.demo.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.demo.common.model.UserDO;

import java.util.List;

/**
 * @author liyunfei
 **/
@Mapper
public interface UserMapperBootVersion {
    /**
     * 通过schoolName条件查询用户列表.
     * @param user User
     * @return List<User>
     */
    List<UserDO> queryUserBySchoolName(UserDO user);
}
