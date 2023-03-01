package com.russ.log.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
                return new OpenAPI()
                        .info(new Info().title("QUERY RUNNER API")
                                .version("1.0.0")
                                .description(" Documentation for Application")
                                .contact(new Contact()
                                        .name("Russel")
                                        .email("russ@gmail.com")) 
                                        
                                
                        		);
                    }
    }
