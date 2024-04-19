package org.example.demo.samples.myabtis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.demo.common.mapper.UserMapper;
import org.example.demo.common.model.UserDO;

import java.io.InputStream;
import java.util.List;

/**
 * @author liyunfei
 **/
public class MybatisBaseSample {
    
    public List<UserDO> sample() throws Exception {
        // 1. 加载配置文件（config文件）
        String configFile = "mybatis/mybatis-config.xml";
        InputStream inputStream = null;
        // 对ClassLoader进行了加载，RPC项目中进行对Class的扫描：直接采用的
        // Thread.currentThread().getContextClassLoader().getResourceAsStream()
        // JVM的基础类加载知识
        inputStream = Resources.getResourceAsStream(configFile);
        
        // 2. 构建SQL Session org.apache.ibatis.session.SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //分析mybatis-config.xml 则需去分析该类Configuration: sqlSessionFactory.getConfiguration()
       
        // 3.数据读取
        // 注意openSession() , 是否基于Connection，是否自动提交，执行类型等。
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // Session的抽象：可做select,获取Connection，可直接commit，select等，也可获取Mapper，Session中做绑定？
            UserMapper userMapper = session.getMapper(UserMapper.class);
            
            // 组建查询参数
            UserDO userParam = new UserDO();
            userParam.setSchoolName("Sunny School");
            // 调用接口展开数据库操作，，反射，，？代理调用？
            List<UserDO> userList = userMapper.queryUserBySchoolName(userParam);
            // 打印查询结果
            for (UserDO user : userList) {
                System.out.println("name : " + user.getName() + " ;  email : " + user.getEmail());
            }
            UserDO userDO = userMapper.queryUserById(1);
            System.out.printf(">>>>测试>>>> Annotation Query %s \n",userDO);
       
            //System.out.println();
            return userList;
        }
        
        //return null;
    }
}
