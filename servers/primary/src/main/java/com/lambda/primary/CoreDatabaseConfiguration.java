package com.lambda.primary;

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

@Getter
@Setter
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "coreEntityManagerFactory",
        transactionManagerRef = "coreTxManager",
        basePackages = {
                "com.lambda.primary.CoreExports.repos"
        }
)
@ConfigurationProperties(
        prefix = "datasource.lambda-core-shared"
)
@EnableAutoConfiguration
public class CoreDatabaseConfiguration {

    //Datasource variables
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    //hibernate configurations
    @Setter
    @Value("${lambda-core-shared.properties.hibernate.ddl-auto}")
    private String ddlAutoType;

    @Setter
    @Value("${lambda-core-shared.properties.hibernate.dialect}")
    private String hibernateDialect;

    @Setter
    @Value("${lambda-core-shared.properties.hibernate.format_sql}")
    private String sqlFormat;


    //Data source initialization
    @Bean(name = "coreDataSource")
    @Primary
    public DataSource dataSource(){
        return DataSourceBuilder.create().
                url(url).
                username(username).
                password(password).
                driverClassName(driverClassName).
                build();
    }

    @Bean(name = "coreEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean coreEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("coreDataSource") DataSource source
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
                .persistenceUnit("core")
                .packages(
                        "com.lambda.primary.CoreExports.entities"
                )
                .properties(properties)
                .build();
    }


    @Bean("coreTxManager")
    @Primary
    public PlatformTransactionManager coreTxManager(
            @Qualifier("coreEntityManagerFactory")
            EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }


}
