package org.tym.blinking.norwaylife.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.SqlTimestampTypeHandler;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.tym.blinking.norwaylife.common.util.PropertyUtil;

import javax.sql.DataSource;

/**
 * Created by tangtomorrow on 2017/3/1.
 */
@Configuration
@PropertySource(value = {"classpath:system.properties"})
public class DataConfig {

    @Autowired
    private Environment env;

    /**
     * DataSource
     *
     * @return
     * @throws Exception
     */
    @Bean
    public DataSource dataSource() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        /*
        dataSource.setDriverClassName(env.getRequiredProperty("database.driver"));
        dataSource.setUrl(env.getRequiredProperty("database.url"));
        dataSource.setUsername(env.getRequiredProperty("database.username"));
        dataSource.setPassword(env.getRequiredProperty("database.password"));
        */
        dataSource.setDriverClassName(PropertyUtil.getString("database.driver"));
        dataSource.setUrl(PropertyUtil.getString("database.url"));
        dataSource.setUsername(PropertyUtil.getString("database.username"));
        dataSource.setPassword(PropertyUtil.getString("database.password"));
        return dataSource;
    }

    /**
     * SqlSessionFactory
     *
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("org.tym.blinking.norwaylife.dal.po");
        return sessionFactory.getObject();
    }

    /**
     * Mybatis包扫描器
     *
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("org.tym.blinking.norwaylife.dal.dao");
        msc.setAnnotationClass(Repository.class);
        return msc;
    }

}
