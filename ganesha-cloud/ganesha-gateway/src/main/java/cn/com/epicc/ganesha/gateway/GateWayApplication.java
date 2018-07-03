package cn.com.epicc.ganesha.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Description: 网关主程序
 * Author: lishangmin
 * Created: 2018-07-02 13:48
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class,args);
    }

}
