package org.example.demo.util;

import org.example.demo.common.model.LeaveDO;
import org.example.demo.common.model.LeaveVO;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * @author liyunfei
 **/
public class ConvertUtilTest {
    @Test
    public void test(){
       // BeanUtils.t
        // 1.hutool工具的BeanUtils
        // 2.mapstruct
        // 3.
        //LeaveMapper mapper = new LeaveMapperImpl();
        // generated-sources
        LeaveVO leaveVO = LeaveVO
            .builder()
            .username("lyf")
            .reason("测试")
            .build();
        LeaveDO convert = LeaveMapper.INSTANCE.convert(leaveVO);
        System.out.println(convert);
        convert = LeaveMapper.INSTANCE.convertByJson(leaveVO);
        System.out.println(convert);
        convert = LeaveMapper.INSTANCE.convertByHutool(leaveVO);
        System.out.println(convert);
    }
}
