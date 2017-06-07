package com.demo.web.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017-06-01.
 */
@Configuration
//mapper文件路径
@MapperScan(basePackages = "com.demo.web.dal.mapperThree", sqlSessionTemplateRef = "thirdSqlSessionTemplate")
public class ThirdDruidDataSourceConfig {

    @Bean(name = "thirdDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.third")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "thirdSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("thirdDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //xml路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/demo/web/dal/mapperThree/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "thirdTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("thirdDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "thirdSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("thirdSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
