package tech.dimitar.axon.dbsource.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        basePackages = {"tech.dimitar.other.database*"},
        entityManagerFactoryRef = "ordersEntityManagerFactory",
        transactionManagerRef = "ordersTransactionManager"
)
public class OrdersDbConfig {

    @Bean(name = "ordersDataSourceProperties")
    @ConfigurationProperties("orders.datasource")
    public DataSourceProperties ordersDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "ordersDataSource")
    @ConfigurationProperties("orders.datasource.configuration")
    public DataSource ordersDatasource(@Qualifier("ordersDataSourceProperties") DataSourceProperties ordersDataSourceProperties) {
        return ordersDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class)
                .build();
    }

    @Bean(name = "ordersEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ordersEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("ordersDataSource") DataSource ordersDatasource) {
        return builder
                .dataSource(ordersDatasource)
                .packages("tech.dimitar.other.database.entities")
                .build();
    }

    @Bean(name = "ordersTransactionManager")
    public PlatformTransactionManager ordersTransactionManager(
            @Qualifier("ordersEntityManagerFactory") EntityManagerFactory ordersEntityManagerFactory) {
        return new JpaTransactionManager(ordersEntityManagerFactory);
    }
}