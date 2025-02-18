package com.app.agenda.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("pessoas")
                .pathsToMatch("/api/pessoas/**")  
                .build();
    }

    @Bean
    public GroupedOpenApi contatosApi() {
        return GroupedOpenApi.builder()
                .group("contatos")
                .pathsToMatch("/api/contatos/**") 
                .build();
    }
}

