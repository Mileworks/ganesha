package cn.com.epicc.ganesha.druid.monitor;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description: 监控配置
 * Author: lishangmin
 * Created: 2018-06-20 11:26
 */
@Configuration
@EnableConfigurationProperties({DruidMonitorProperties.class,DruidFilterProperties.class})
public class DruidMonitor {

    @Autowired
    DruidMonitorProperties druidMonitorProperties;

    @Autowired
    DruidFilterProperties druidFilterProperties;

    /**
     * 注册一个StatViewServlet
     */
    @Bean
    public ServletRegistrationBean DruidStatViewServlet(){
        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        //添加初始化参数：initParams

        //白名单：
        servletRegistrationBean.addInitParameter("allow",druidMonitorProperties.getAllow());
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny",druidMonitorProperties.getDeny());
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername",druidMonitorProperties.getUsername());
        servletRegistrationBean.addInitParameter("loginPassword",druidMonitorProperties.getPassword());
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable",druidMonitorProperties.getResetEnable());
        return servletRegistrationBean;
    }

    /**
     * 注册一个：filterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns(druidFilterProperties.getPattern());

        //过滤不需要监控的后缀.
        filterRegistrationBean.addInitParameter("exclusions",druidFilterProperties.getExclusions());
        return filterRegistrationBean;
    }
}
