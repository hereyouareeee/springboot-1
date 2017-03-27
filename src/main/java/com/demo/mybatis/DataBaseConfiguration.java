package com.demo.mybatis;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.demo.model.DBConfig;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huguoju on 2016/12/29.
 * 数据库配置：解析properties文件
 */
@Slf4j
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class DataBaseConfiguration  {
    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;
    @Autowired
    private DBConfig dbConfig;

    @Bean(name="writeDataSource", destroyMethod = "close", initMethod="init")
    @Primary
  //  @ConfigurationProperties(prefix = "spring.datasource",locations = "classpath:mybatis/mybatis.properties")
    public DataSource writeDataSource() throws SQLException {
        log.info("-------------------- writeDataSource init ---------------------");
//        DruidXADataSource druidXADataSource=new DruidXADataSource();
//        druidXADataSource.setDriverClassName(dbConfig.getDriverClassName());
//        druidXADataSource.setUrl(dbConfig.getUrl());
//        druidXADataSource.setPassword(dbConfig.getPassword());
//        druidXADataSource.setUsername(dbConfig.getUsername());
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dbConfig.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dbConfig.getPassword());
        mysqlXaDataSource.setUser(dbConfig.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("writeDataSource");

        xaDataSource.setMinPoolSize(dbConfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(dbConfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(dbConfig.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(dbConfig.getBorrowConnectionTimeout());
        /** login-timeout java数据库连接池，最大可等待获取datasouce的时间 **/
        xaDataSource.setLoginTimeout(dbConfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(dbConfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(dbConfig.getMaxIdleTime());
        xaDataSource.setTestQuery(dbConfig.getValidationQuery());
        return xaDataSource;
    }
    /**
     * 有多少个从库就要配置多少个
     * @return
     */
    @Bean(name = "readDataSource1")
    @ConfigurationProperties(prefix = "spring.slave",locations = "classpath:mybatis/mybatis.properties")
    public DataSource readDataSourceOne(){
        log.info("-------------------- readDataSourceOne init ---------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "readDataSource2")
    @ConfigurationProperties(prefix = "spring.read2",locations = "classpath:mybatis/mybatis.properties")
    public DataSource readDataSourceTwo() {
        log.info("-------------------- readDataSourceTwo init ---------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }
    @Bean("readDataSources")
    public List<DataSource> readDataSources(){
        List<DataSource> dataSources=new ArrayList<DataSource>();
        dataSources.add(readDataSourceOne());
        dataSources.add(readDataSourceTwo());
        return dataSources;
    }
//    @Bean(name = "transactionManager")
//    public DataSourceTransactionManager transactionManager() {
//        log.info("-------------------- transactionManager init ---------------------");
//        return new DataSourceTransactionManager(writeDataSource());
//    }
}
