package com.demo.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 自定义事务
 * Created by huguoju on 2016/12/29.
 */
@Configuration
@EnableTransactionManagement
@Slf4j
public class DataSourceTransactionManager extends DataSourceTransactionManagerAutoConfiguration {
    /**
     * 自定义事务
     * MyBatis自动参与到spring事务管理中，无需额外配置，只要org.mybatis.spring.SqlSessionFactoryBean引用的数据源与DataSourceTransactionManager引用的数据源一致即可，否则事务管理会不起作用。
     * @return
     */
    @Resource(name = "writeDataSource")
    private DataSource dataSource;
    @Bean(name = "transactionManager")
    public org.springframework.jdbc.datasource.DataSourceTransactionManager transactionManagers() {
        log.info("-------------------- transactionManager init ---------------------");
        return new org.springframework.jdbc.datasource.DataSourceTransactionManager(dataSource);
    }
}
