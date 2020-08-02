package com.avps.portfolio.api.configuration;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages            = { "com.avps.portfolio.api.repository" },
    entityManagerFactoryRef = "entityManagerFactory",
    transactionManagerRef   = "transactionManager"
)
public class JPAConfiguration {

    @Primary
    @Bean("dataSource")
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
            .driverClassName("org.postgresql.Driver")
            .url("jdbc:postgresql://localhost:5432/avps")
            .username("postgres")
            .password("il87061l12")
            .build();
    }

    @Primary
    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
        EntityManagerFactoryBuilder factory,
        @Qualifier("dataSource") DataSource dataSource
    ) {
        return factory
            .dataSource(dataSource)
            .packages("com.avps.portfolio.api.domain")
            .persistenceUnit("avpsPU")
            .build();
    }

    @Primary
    @Bean("transactionManager")
    public PlatformTransactionManager getTransaction(
        @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
