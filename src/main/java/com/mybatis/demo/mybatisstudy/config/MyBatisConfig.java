package com.mybatis.demo.mybatisstudy.config;

import com.mybatis.demo.mybatisstudy.annotation.MyBatisMapperScan;
import com.mybatis.demo.mybatisstudy.registar.MyBatisBeanDefinitionRegistar;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * @author marco pan
 * @ClassName MyBatisConfiguration
 * @Description 应用配置类
 * @date 2021年09月30日 11:47 下午
 */
@Configuration
@MyBatisMapperScan("com.mybatis.demo.mybatisstudy.mapper")
@Import(MyBatisBeanDefinitionRegistar.class)
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        return sessionFactoryBean.getObject();
    }

//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactory() {
//        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//        sessionFactoryBean.setDataSource(datasource());
//        return sessionFactoryBean;
//    }
//
//    @Bean
//    public DataSource datasource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
//        dataSource.setUsername("root");
//        dataSource.setPassword("12345678");
//        return dataSource;
//    }
}
