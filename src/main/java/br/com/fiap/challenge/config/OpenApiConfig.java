package br.com.fiap.challenge.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("RESTFUL API Challenge")
                .version("v1")
                .description("API do Challenge - Fiap")
                .termsOfService("")
                .license(new License().name("Apache 2.0").url(""))
        );
    }
}
