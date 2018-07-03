package cn.com.epicc.ganesha.druid.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description: 数据基础配置属性
 * Author: lishangmin
 * Created: 2018-06-20 11:26
 */
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class DruidProperties {

    /**
     * 数据库连接地址
     */
    private String url;

    /**
     * 数据库用户名
     */
    private String username;

    /**
     * 数据库密码
     */
    private String password;

    /**
     * 数据库驱动
     */
    private String driverClassName;

    /**
     * 数据源类型
     */
    private String type;

    /**
     * 扩展插件，
     * 监控统计：filter:stat
     * 日志：filter:log4j
     * 防御sql注入：filter:wall
     */
    private String filters;

    /**
     * 最大连接池数量
     */
    private Integer maxActive;

    /**
     * 初始化物理连接数
     */
    private Integer initialSize;

    /**
     * 最大等待时间，单位：毫秒
     */
    private Integer maxWait;

    /**
     * 最小连接池数量
     */
    private Integer minIdle;

    /**
     * 有两个含义：
     * 1) Destroy线程会检测连接的间隔时间
     * 2) testWhileIdle的判断依据，详细看testWhileIdle属性的说明
     */
    private Long timeBetweenEvictionRunsMillis;

    /**
     * 一个连接在池中最小生存的时间(ms)
     */
    private Long minEvictableIdleTimeMillis;

    /**
     * 用来检测连接是否有效的sql
     */
    private String validationQuery;

    /**
     * 建议配置为true，不影响性能，并且保证安全性。
     * 申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，
     * 执行validationQuery检测连接是否有效。
     */
    private boolean testWhileIdle;

    /**
     * 申请连接时执行validationQuery检测连接是否有效，
     * 做了这个配置会降低性能。
     */
    private boolean testOnBorrow;

    /**
     * 归还连接时执行validationQuery检测连接是否有效，
     * 做了这个配置会降低性能
     */
    private boolean testOnReturn;

    /**
     * 是否缓存preparedStatement，也就是PSCache。
     * PSCache对支持游标的数据库性能提升巨大，
     * 比如说oracle。在mysql下建议关闭。
     */
    private boolean poolPreparedStatements;

    /**
     * 要启用PSCache，必须配置大于0，
     * 当大于0时，poolPreparedStatements自动触发修改为true。
     * 在Druid中，不会存在Oracle下PSCache占用内存过多的问题，
     * 可以把这个数值配置大一些，比如说100
     */
    private Integer maxOpenPreparedStatements;

}
