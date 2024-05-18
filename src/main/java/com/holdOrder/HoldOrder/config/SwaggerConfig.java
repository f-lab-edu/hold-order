package com.holdOrder.HoldOrder.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("주문에 잘 견디는 API")
                        .description("대용량 트래픽에서 잘 견디는 객체지향 프로젝트")
                        .version("1.0.0"));
    }
}