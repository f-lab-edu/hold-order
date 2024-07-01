package com.holdOrder.HoldOrder.api.config;

import com.holdOrder.core.config.CoreConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CoreConfig.class)
public class ApiConfig {
}
