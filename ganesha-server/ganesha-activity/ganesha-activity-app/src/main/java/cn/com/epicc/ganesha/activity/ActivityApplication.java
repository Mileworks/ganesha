package cn.com.epicc.ganesha.activity;

import cn.com.epicc.ganesha.druid.config.DruidConfig;
import cn.com.epicc.ganesha.druid.monitor.DruidMonitor;
import cn.com.epicc.ganesha.swagger.SwaggerUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

/**
 * Description: 活动模块
 * Author: lishangmin
 * Created: 2018-07-09 10:31
 */
@SpringBootApplication
@EnableEurekaClient
@Import({DruidConfig.class, DruidMonitor.class, SwaggerUtil.class})
public class ActivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivityApplication.class,args);
    }

}
