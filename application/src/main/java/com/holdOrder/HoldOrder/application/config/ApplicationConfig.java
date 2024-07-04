package com.holdOrder.HoldOrder.application.config;


import com.holdOrder.HoldOrder.core.config.CoreConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CoreConfig.class)
@ComponentScan(basePackages = "com.holdOrder.HoldOrder.application")
public class ApplicationConfig {
}
