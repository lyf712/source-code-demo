package org.example.demo.samples.myabtis.docs;

/**
 * @author liyunfei
 **/
public enum SqlSessionFactoryTypeEnum {
    
    /**
     *
     */
    JAVA_CONFIG(SimpleConfigSqlSessionFactoryBuilder.class),
    
    /**
     *
     */
    XML_CONFIG(SimpleXmlSqlSessionFactoryBuilder.class);
    
    private final Class<?> clazz;
    
    SqlSessionFactoryTypeEnum(Class<?> clazz) {
        this.clazz = clazz;
    }
    
    public Class<?> getClazz() {
        return clazz;
    }
}
