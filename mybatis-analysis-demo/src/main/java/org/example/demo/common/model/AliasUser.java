package org.example.demo.common.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author liyunfei
 **/
@Alias("User")
@Data
public class AliasUser implements Serializable {
    
    private Integer id;
    
    private String name;
    
    private String email;
    
    private Integer age;
    
    private Integer sex;
    
    private String schoolName;
    
}
