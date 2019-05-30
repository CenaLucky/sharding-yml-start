package com.cs.yml.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author:CaoShuai
 * @dateTime:5/28/2019 4:00 PM
 * @description:
 */
@Configuration
@MapperScan(basePackages = {"com.cs.yml.dao"},
        sqlSessionTemplateRef = "sqlSessionTemplate")
public class MyBatisConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean("sqlSessionFactory")
    public SqlSessionFactory shardingSqlSessionFactory(@Value("${mybatis.mapper-locations}") String mapperLocations,
                                                       @Value("${mybatis.config-location}") String configLocation) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Resource[] itemResource = new PathMatchingResourcePatternResolver().getResources(mapperLocations);
        Resource[] resources = Arrays.copyOf(itemResource, itemResource.length);
        sqlSessionFactoryBean.setMapperLocations(resources);
        sqlSessionFactoryBean.setConfigLocation(
                new PathMatchingResourcePatternResolver().getResource(configLocation)
        );
        return sqlSessionFactoryBean.getObject();
    }
    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate shardingSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }
}
