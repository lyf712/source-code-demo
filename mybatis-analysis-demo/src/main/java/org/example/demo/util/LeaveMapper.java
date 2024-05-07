package org.example.demo.util;

import cn.hutool.core.bean.BeanUtil;
import org.example.demo.common.model.LeaveDO;
import org.example.demo.common.model.LeaveVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author liyunfei
 **/
@Mapper
public interface LeaveMapper {
    
    LeaveMapper INSTANCE = Mappers.getMapper(LeaveMapper.class);
    
    LeaveDO convert(LeaveVO leaveVO);
    
    default LeaveDO convertByJson(LeaveVO leaveVO) {
        return JsonUtils.fromJson(JsonUtils.toJson(leaveVO), LeaveDO.class);
    }
    
    default LeaveDO convertByHutool(LeaveVO leaveVO) {
        //return JsonUtils.fromJson(JsonUtils.toJson(leaveVO), LeaveDO.class);
        return BeanUtil.toBean(leaveVO, LeaveDO.class);
    }
}
