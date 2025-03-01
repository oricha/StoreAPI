package com.kmuniz.storeapi.store_api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.kmuniz.storeapi.store_api.domain")
@EnableJpaRepositories("com.kmuniz.storeapi.store_api.repos")
@EnableTransactionManagement
public class DomainConfig {
}
