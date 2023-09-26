package com.lambda.primary.Configurations;

import jakarta.persistence.EntityManagerFactory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "contentEntityManagerFactory",
        transactionManagerRef = "contentTxManager",
        basePackages = {
            "com.lambda.primary.ContentExports.repos"
        }
)
@ConfigurationProperties(
        prefix = "datasource.lambda-content-private"
)
@Getter
@Setter
public class ContentDatabaseConfiguration {

    //Datasource variables
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    //hibernate configurations
    @Setter
    @Value("${lambda-content-private.properties.hibernate.ddl-auto}")
    private String ddlAutoType;

    @Setter
    @Value("${lambda-content-private.properties.hibernate.dialect}")
    private String hibernateDialect;

    @Setter
    @Value("${lambda-content-private.properties.hibernate.format_sql}")
    private String sqlFormat;

    @Bean(name="contentDataSource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().
                username(username).
                url(url).
                password(password).
                driverClassName(driverClassName).
                build();
    }




    @Bean(name="contentEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean contentEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("contentDataSource") DataSource source
    ){
        //properties configurations
        HashMap<String,String> properties = new HashMap<>();
        properties.put(
                "hibernate.hbm2ddl.auto",
                ddlAutoType
        );
        properties.put(
                "hibernate.dialect",
                hibernateDialect
        );
        properties.put(
                "hibernate.format_sql",
                sqlFormat
        );

        //LocalContainerEntityManagerFactoryBean instantiation and configuration

        return builder.dataSource(source)
                .persistenceUnit("content")
                .packages(
                        "com.lambda.primary.ContentExports.entities"
                )
                .properties(properties)
                .build();
    }


    @Bean(name="contentTxManager")
    public PlatformTransactionManager contentTxManager(
            @Qualifier("contentEntityManagerFactory")
            EntityManagerFactory entityManagerFactory
    ){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
