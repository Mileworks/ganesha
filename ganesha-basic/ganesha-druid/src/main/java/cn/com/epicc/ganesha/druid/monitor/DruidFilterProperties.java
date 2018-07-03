package cn.com.epicc.ganesha.druid.monitor;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description: 过滤器属性
 * Author: lishangmin
 * Created: 2018-06-20 16:41
 */
@ConfigurationProperties(prefix = "druid.filter")
@Data
public class DruidFilterProperties {

    /**
     * 匹配路径
     */
    private String pattern;

    /**
     * 不需要监控的后缀
     */
    private String exclusions;

}
