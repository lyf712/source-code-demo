package org.example.demo.common.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liyunfei
 **/
@Data
@Builder
public class LeaveVO implements Serializable {
    
    private String username;
    private String reason;
    private Integer status;
    private Integer days;
    private List<String> audit;
    private Date startTime;
    private Date endTime;
    
}
