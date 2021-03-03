package com.example.customer.service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;

@Profile("development")
@Configuration
public class DevelopmentConfiguration {

  private final static Logger LOGGER = LoggerFactory.getLogger(DevelopmentConfiguration.class);

  @Bean
  public DataSource dataSource() throws SQLException {
    DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:com/example/customer/config/schema-development.sql").build();
    LOGGER.info("H2 database is running with metadata: {}", dataSource.getConnection().getMetaData().toString());

    return dataSource;
  }
}
