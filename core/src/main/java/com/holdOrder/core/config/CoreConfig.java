package com.holdOrder.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.holdOrder.core")
@EntityScan(basePackages = "com.holdOrder.core.domain")
@EnableJpaRepositories(basePackages = "com.holdOrder.core.domain")
public class CoreConfig {
}
