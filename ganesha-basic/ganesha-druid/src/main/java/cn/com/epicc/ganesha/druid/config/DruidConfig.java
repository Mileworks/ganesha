package cn.com.epicc.ganesha.druid.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Description: 数据基础配置
 * Author: lishangmin
 * Created: 2018-06-20 15:46
 */
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@ConditionalOnClass(DruidDataSource.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@Slf4j
@EnableTransactionManagement
public class DruidConfig {

    @Autowired
    DruidProperties properties;

    @Bean(name = "dataSource")
    @Qualifier("dataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        //数据库连接地址
        dataSource.setUrl(properties.getUrl());
        //数据库用户名
        dataSource.setUsername(properties.getUsername());
        //数据库密码
        dataSource.setPassword(properties.getPassword());
        //数据库驱动
        dataSource.setDriverClassName(properties.getDriverClassName());
        if (properties.getInitialSize() > 0) {
            dataSource.setInitialSize(properties.getInitialSize());
        }
        if (properties.getMinIdle() > 0) {
            dataSource.setMinIdle(properties.getMinIdle());
        }
        if (properties.getMaxActive() > 0) {
            dataSource.setMaxActive(properties.getMaxActive());
        }
        dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(properties.getValidationQuery());
        dataSource.setTestWhileIdle(properties.isTestWhileIdle());
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
        dataSource.setTestOnReturn(properties.isTestOnReturn());
        dataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
        dataSource.setMaxOpenPreparedStatements(properties.getMaxOpenPreparedStatements());
        try {
            dataSource.setFilters(properties.getFilters());
            dataSource.init();
        } catch (SQLException e) {
            log.error("Druid Init Exception",e);
        }
        return dataSource;
    }

    @Bean(name = "txManager")
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
