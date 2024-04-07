package org.example.demo.common.mapper;

import org.apache.ibatis.annotations.Select;
import org.example.demo.common.model.UserDO;

import java.util.List;

/**
 * @author liyunfei
 **/
public interface UserMapper {
    
    /**
     * 通过schoolName条件查询用户列表.
     * @param user User
     * @return List<User>
     */
    List<UserDO> queryUserBySchoolName(UserDO user);
    
    
    @Select("SELECT * FROM `user` WHERE `id` = #{id}")
    UserDO queryUserById(Integer id);
}
