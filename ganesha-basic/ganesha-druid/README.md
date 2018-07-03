# flypig-druid
    数据库连接池

#### 代码结结构
    config    数据源基本配置
    monitor   数据源监控配置

#### 使用说明
    1. 基本配置
        1) 保证使用项目能够扫描到【 DruidConifg 】，示例如下：
            @SpringBootApplication
            @Import({DruidConifg.class})
            public class AipApplication {
                main(){
                    //do something....
                }
            }
        2) 增加属性配置，示例如下：
            spring:
              datasource:
                url: jdbc:mysql://localhost:3306/PICC_EBSS?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false
                username: root
                password: root
                driver-class-name: com.mysql.jdbc.Driver
                type: com.alibaba.druid.pool.DruidDataSource
                filters: stat
                maxActive: 1000
                initialSize: 10
                maxWait: 60000
                minIdle: 500
                timeBetweenEvictionRunsMillis: 60000
                minEvictableIdleTimeMillis: 300000
                validationQuery: select 'x'
                testWhileIdle: true
                testOnBorrow: false
                testOnReturn: false
                poolPreparedStatements: true
                maxOpenPreparedStatements: 20
    2. 监控配置
        1) 保证使用项目能够扫描到【 DruidMonitor 】，示例如下：
            @SpringBootApplication
            @Import({DruidMonitor.class})
            public class AipApplication {
                main(){
                    //do something....
                }
            }
        2) 添加配置属性，示例如下：
            druid:
              monitor:
                pattern: /druid/*
                username: admin
                password: admin
                allow: 127.0.0.1,192.168.0.1
                deny: 192.168.1.73
                resetEnable: false
              filter:
                pattern: /*
                exclusions: '*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*'
        3) 监控地址：http://host:port/project/druid/index.html

