# ganesha-redis
    通用Redis服务层

#### 代码结构 包名-类名
    config   Redis初始化配置
    key      RedisKey抽象模板
    service  Redis服务层

#### 使用说明
    1. 确保引用模块能够扫描到RedisConfig.class,例如
        @SpringBootApplication
        @Import({RedisConfig.class})
        public class AipApplication {
            main(){
                //do something....
            }
        }
    2. 所有的RedisKey必须继承 BasePrefix.class
    3. 在引用模块添加配置
        redis:
          sentinel: false
          masterName: resque
          maxIdle: 200
          maxTotal: 2048
          maxWaitMillis: 1000
          hosts: 127.0.0.1:6379
          db: 0
          password:
