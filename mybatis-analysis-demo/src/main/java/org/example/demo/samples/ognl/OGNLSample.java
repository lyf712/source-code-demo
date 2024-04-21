package org.example.demo.samples.ognl;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyunfei
 **/
public class OGNLSample {
    
    @Data
    @AllArgsConstructor
    public static class User {
        private String name;
    }
    
    public void sample() throws OgnlException {
        Map<String, User> userMap = new HashMap<>();
        userMap.put("user1",new User("lyf"));
        Object value = Ognl.getValue("#user1.name", userMap, new Object());
        System.out.println(value);
    }
    
}
