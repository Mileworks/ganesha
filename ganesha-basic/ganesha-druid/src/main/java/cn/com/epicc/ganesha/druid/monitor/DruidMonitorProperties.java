package cn.com.epicc.ganesha.druid.monitor;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description: Druid监控实行
 * Author: lishangmin
 * Created: 2018-06-20 16:30
 */
@ConfigurationProperties(prefix = "druid.monitor")
@Data
public class DruidMonitorProperties {

    /**
     * 匹配路径
     */
    private String pattern;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 白名单
     */
    private String allow;

    /**
     * 黑名单
     */
    private String deny;

    /**
     * 是否禁用RestAll
     */
    private String resetEnable;

}
