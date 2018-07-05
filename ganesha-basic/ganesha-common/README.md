# ganesha-common
    公共模块，包含通用接口模板、通用异常处理类、工具类

#### 代码结构
    1. result 通用返回结果模板
       |-- Result.class                  所有通过Controller返回报文都必须使用该类
       |-- ResultCode.class              各个模块所有自定义异常信息必须继承该类
    2. util   通用工具
       |-- CommonUtil                    包含基础校验、简单生成UUID等
       |-- DateTimeUtil                  时间类型工具
    3. exception 基础自定异常
       |-- FlyPigException.class         自定义异常
       |-- FlyPigExceptionHandler.class  公用异常处理
