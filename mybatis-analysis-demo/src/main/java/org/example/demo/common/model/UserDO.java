package org.example.demo.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liyunfei
 **/
@Data
public class UserDO implements Serializable {
    
    private Integer id;
    
    private String name;
    
    private String email;
    
    private Integer age;
    
    private Integer sex;
    
    private String schoolName;
    
    
}
