package com.example.encore_spring_pjt.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/*
@Component : 객체 생성과 라이프사이클 관리를 spring container 위임하겠다라는 의미
Inversion of Control (IOC) : 제어의 역행
- IOC (Dependency Injection(DI), Dependency Lookup(DL))
- @Controller
- @Service
- @Repository
- @Bean

환경설정에 관련된 객체는
- @Configuration

Dependency Injection 관련 이노테이션으로
spring container(ApplicationContext) 관리하는 객체를 가져다 쓸 수 있다.
- Autowired
- Injection
- Resource
- Qulified
 */

@Configuration
@PropertySource("classpath:/application.properties")
public class MariadbConfig {
    //DI 구현
    @Autowired
    private ApplicationContext context;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig(){
        HikariConfig config = new HikariConfig();
        return config;
    }

    @Bean
    public DataSource dataSource(){
         return new HikariDataSource(hikariConfig());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource());
        factory.setMapperLocations(context.getResource("classpath:/mapper/BoardMapper.xml"));
        factory.setConfiguration(myConfiguration());
        return factory.getObject();
    }

    @Bean("encore")
    public SqlSessionTemplate sqlSession() throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration myConfiguration(){
        return new org.apache.ibatis.session.Configuration();
    }
}
