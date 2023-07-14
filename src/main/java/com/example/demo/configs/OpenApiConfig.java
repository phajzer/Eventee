package com.example.demo.configs;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi customApi() {
        return GroupedOpenApi.builder()
                .group("api")
                .packagesToScan("src/main/java/com/example/demo/controllers") // Zmień na pakiet, w którym znajdują się Twoje kontrolery
                .build();
    }
}
