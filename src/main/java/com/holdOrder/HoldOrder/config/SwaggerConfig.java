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
                        .title("조회 성능이 좋은 API")
                        .description("상품 검색 성능이 빠른 프로젝트")
                        .version("1.0.0"));
    }
}