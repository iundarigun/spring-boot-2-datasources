package br.com.s2it.blog;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
public class DBConfig {

    @Bean("primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource primaryDataSource){
        return new JdbcTemplate(primaryDataSource);
    }

    @Bean("secundaryDataSource")
    @ConfigurationProperties(prefix="postgres.datasource")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("secundaryJdbcTemplate")
    public JdbcTemplate secundaryJdbcTemplate(@Qualifier("secundaryDataSource") DataSource secundaryDataSource){
        return new JdbcTemplate(secundaryDataSource);
    }
}
