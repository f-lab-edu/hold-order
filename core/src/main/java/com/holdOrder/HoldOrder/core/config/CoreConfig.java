package com.holdOrder.HoldOrder.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.holdOrder.HoldOrder.core")
@EntityScan(basePackages = "com.holdOrder.HoldOrder.core.domain")
@EnableJpaRepositories(basePackages = "com.holdOrder.HoldOrder.core.domain")
public class CoreConfig {
}
