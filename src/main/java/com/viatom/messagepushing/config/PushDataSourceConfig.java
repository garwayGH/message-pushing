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
 * 配置push库数据源
 * @author qiujiawei
 * @description PushDataSourceConfig
 * @date 2020/11/27 14:27
 */
@Configuration
@MapperScan(basePackages = "com.viatom.messagepushing.mapper.push",sqlSessionTemplateRef = "pushSqlSessionTemplate")
public class PushDataSourceConfig {

    @Resource
    PushDataBaseProperties pushDataBaseProperties;

    /**
     * 创建数据源
     * @return
     */
    @Bean(name = "pushDS")
    @Primary
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(pushDataBaseProperties.getDriverClassName())
                .url(pushDataBaseProperties.getUrl())
                .username(pushDataBaseProperties.getUsername())
                .password(pushDataBaseProperties.getPassword())
                .type(DruidDataSource.class)
                .build();
    }

    /**
     * 创建sqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "pushSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("pushDS") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/push/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 创建事务管理器
     * @param dataSource
     * @return
     */
    @Bean(name = "pushTransactionManager")
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("pushDS") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 创建SqlSessionTemplate
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "pushSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("pushSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
