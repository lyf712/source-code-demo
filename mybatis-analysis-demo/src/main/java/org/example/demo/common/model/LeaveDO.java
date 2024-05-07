package org.example.demo.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liyunfei
 **/
@Data
public class LeaveDO implements Serializable {
    
    private String username;
    private String reason;
    private Integer status;
    private Integer days;
    private List<String> audit;
    private Date startTime;
    private Date endTime;
    private Long createGmt = System.currentTimeMillis();
    private Long updateGmt = System.currentTimeMillis();
}
