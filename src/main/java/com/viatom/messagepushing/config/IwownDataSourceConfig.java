package com.viatom.messagepushing.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * iwown库数据源
 * @author qiujiawei
 * @description IwownDataSourceConfiger
 * @date 2020/11/27 15:30
 */
@Configuration
@MapperScan(basePackages = "com.viatom.messagepushing.mapper.iwown",sqlSessionTemplateRef = "iwownSqlSessionTemplate")
public class IwownDataSourceConfig {

    @Resource
    IwownDataBaseProperties iwownDataBaseProperties;

    /**
     * 创建数据源
     * @return
     */
    @Bean(name = "iwownDS")
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(iwownDataBaseProperties.getDriverClassName())
                .url(iwownDataBaseProperties.getUrl())
                .username(iwownDataBaseProperties.getUsername())
                .password(iwownDataBaseProperties.getPassword())
                .type(DruidDataSource.class)
                .build();
    }

    /**
     * 创建sqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "iwownSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("iwownDS") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/iwown/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 创建事务管理器
     * @param dataSource
     * @return
     */
    @Bean(name = "iwownTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("iwownDS") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 创建SqlSessionTemplate
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "iwownSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("iwownSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
