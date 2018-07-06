package cn.com.epicc.ganesha.integral;

import cn.com.epicc.ganesha.druid.config.DruidConfig;
import cn.com.epicc.ganesha.druid.monitor.DruidMonitor;
import cn.com.epicc.ganesha.swagger.SwaggerUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-04 10:12
 */
@SpringBootApplication
@EnableEurekaClient
@Import({DruidConfig.class, DruidMonitor.class, SwaggerUtil.class})
public class IntegralApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegralApplication.class,args);
    }

}
