package com.app.agenda.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

   
    @Bean
    public GroupedOpenApi pessoasApi() {
        return GroupedOpenApi.builder()
                .group("pessoas") 
                .pathsToMatch("/pessoas/**") 
                .build();
    }


    @Bean
    public GroupedOpenApi contatosApi() {
        return GroupedOpenApi.builder()
                .group("contatos") 
                .pathsToMatch("/contatos/**") 
                .build();
    }


    @Bean
    public GroupedOpenApi apiGeral() {
        return GroupedOpenApi.builder()
                .group("geral") 
                .pathsToMatch("/**") 
                .build();
    }
}
