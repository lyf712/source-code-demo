package org.example.demo.samples.myabtis.docs;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyunfei
 **/
public class SqlSessionFactoryRegistry {
    
    private static final Map<SqlSessionFactoryTypeEnum, SqlSessionFactory> sqlSessionFactoryMap =
        new ConcurrentHashMap<>();
    
    static {
        SqlSessionFactoryTypeEnum[] values = SqlSessionFactoryTypeEnum.values();
        for (SqlSessionFactoryTypeEnum value : values) {
            try {
                SimpleSqlSessionFactoryBuilder sqlSessionFactoryBuilder =
                    (SimpleSqlSessionFactoryBuilder) value.getClazz().newInstance();
                sqlSessionFactoryMap.put(value, sqlSessionFactoryBuilder.build());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public static SqlSessionFactory getByType(SqlSessionFactoryTypeEnum type){
        return sqlSessionFactoryMap.getOrDefault(type,null);
    }
    
}
