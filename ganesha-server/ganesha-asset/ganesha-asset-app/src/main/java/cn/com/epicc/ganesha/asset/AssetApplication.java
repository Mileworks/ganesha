package cn.com.epicc.ganesha.asset;

import cn.com.epicc.ganesha.druid.config.DruidConfig;
import cn.com.epicc.ganesha.druid.monitor.DruidMonitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

/**
 * Description: 资产管理对外开放API服务
 * Author: lishangmin
 * Created: 2018-05-22 14:20
 */
@SpringBootApplication
@EnableEurekaClient
@Import({DruidConfig.class, DruidMonitor.class})
public class AssetApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssetApplication.class,args);
    }

}
