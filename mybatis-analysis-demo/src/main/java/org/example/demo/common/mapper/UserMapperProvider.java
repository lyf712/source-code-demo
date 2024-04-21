package org.example.demo.common.mapper;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author liyunfei
 **/
public class UserMapperProvider {
    public String queryUserById(){
        return new SQL()
            .SELECT("*")
            .FROM("user")
            .WHERE("id = #{id}")
            .toString();
    }
}
