package io.egen.harika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:database.properties")
public class JPAConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
        emfBean.setDataSource(dataSource());
        emfBean.setPackagesToScan("io.egen.harika.entity");
        emfBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emfBean.setJpaProperties(jpaProperties());
        return emfBean;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dmdataSource = new DriverManagerDataSource();
        dmdataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dmdataSource.setUrl(env.getProperty("db.url"));
        dmdataSource.setUsername(env.getProperty("db.user"));
        dmdataSource.setPassword(env.getProperty("db.password"));
        return dmdataSource;
    }

    @Bean
    public PlatformTransactionManager txnManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(emf);
        return transactionManager;
    }

    private Properties jpaProperties() {
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl"));
        return props;
    }
}
