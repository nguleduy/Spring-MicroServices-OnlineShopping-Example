package com.example.sales.order.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableSwagger2
@EnableJpaRepositories
@SpringBootApplication
public class SalesOrderServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SalesOrderServiceApplication.class, args);
  }

}
