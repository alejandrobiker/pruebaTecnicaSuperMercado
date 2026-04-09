package com.todocodeacademy.PruebaTecSupermercado.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        // URL swagger: http://localhost:8080/swagger-ui/index.html
        return new OpenAPI()
                .info(new Info()
                        .title("API Supermercado TodoCode")
                        .version("1.0")
                        .description("Documentación de endpoints para la gestión de productos y ventas"));
    }

}
