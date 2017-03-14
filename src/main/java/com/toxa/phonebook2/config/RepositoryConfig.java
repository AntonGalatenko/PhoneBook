package com.toxa.phonebook2.config;

import com.toxa.phonebook2.model.dao.PhoneDao;
import com.toxa.phonebook2.model.dao.UserDao;
import com.toxa.phonebook2.model.dao.impl.PhoneDaoImpl;
import com.toxa.phonebook2.model.dao.impl.UserDaoImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:conf.properties")
public class RepositoryConfig {

    private SessionFactory sessionFactory;

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("app.jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("app.jdbc.url"));
        dataSource.setUsername(env.getProperty("app.jdbc.username"));
        dataSource.setPassword(env.getProperty("app.jdbc.password"));
        return dataSource;
    }

    @Bean
    public Properties hibernateProperties() {
        final Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.connection.Charset", "UTF-8");
        properties.put("hibernate.connection.useUnicode", "true");
        properties.put("hibernate.connection.characterEncoding", "UTF-8");
        return properties;
    }

    @Bean
    public SessionFactory sessionFactory() {
        if (sessionFactory == null){
            sessionFactory = new LocalSessionFactoryBuilder(dataSource())
                    .scanPackages("com.toxa.phonebook2")
                    .addProperties(hibernateProperties())
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    @Bean
    public UserDao userDao(){
        return new UserDaoImpl();
    }

    @Bean
    public PhoneDao phoneDao(){
        return new PhoneDaoImpl();
    }
}
