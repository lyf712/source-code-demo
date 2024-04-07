# 一、关键记录

### JDBC

1. 熟悉JDBC的URL配置（包括，单机版、主从版，时区等参数）
2. 熟悉JDBC的实现过程，DriverManager的设计和ConnectionImpl的实现与抽象

### Mybatis

#### 配置文件方面
1. 熟悉Mapper文件和config文件的参数抽象
2. 整合SpringBoot的Mybatis时

mybatis:
mapper-locations: classpath:/mapper/*.xml # 如果你的 mapper 文件放在特定位置，请修改此处路径
type-aliases-package: org.example.rich.console.domain.entity # 你的实体类所在的包路径

# MyBatis 配置



### 其他思考

1. IDEA如何去静态检查Mapper文件等（通过已有的session查询MYSQL的情况，再去检查Mapper的是否合理性）
2. 

