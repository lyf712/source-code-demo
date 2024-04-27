package org.example.demo.common.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author liyunfei
 **/
@Alias("UserExample")
@Data
public class UserExample {
    
    private boolean isLimit;
    
    private long limitNum = 5;
}
