# 一、工程描述

用于阅读源码相关的示例（基本演化过程 & 最佳实践），阅读的源码主要包括以下：

## Mybatis

yeecode的易哥的源码阅读指导：

1. [示例代码](https://github.com/yeecode/MyBatisDemo/blob/master/README.md)
- 参考该实践过程去分析Mybatis的基本作用、使用以及基本原理
- 采用分支去进行迭代开发管理（示例1的不采用ORM至示例29的Guava示例）
- version_1.0.1 - 1.0.29

注：对比采用子module,需要调整结构划分,提升复用性。
对于基础类设计：
1. 基本环境使用搭建（JDBC使用，集成Mybatis，SpringBoot基础Mybatis封装）
2. 基础&设计模式（装饰器、反射功能、静态代理、基于反射的动态代理、模板模式、
3. Mybatis的基本理解（基于1的使用过程、TypeParameterResolver理解
4. 深入理解

![img.png](mybatis-analysis-demo/pic/img.png)


2. [源码批注](https://github.com/yeecode/MyBatisCN/blob/master/src/main/java/org/apache/ibatis/binding/MapperProxy.java)

## Spring

# 二、