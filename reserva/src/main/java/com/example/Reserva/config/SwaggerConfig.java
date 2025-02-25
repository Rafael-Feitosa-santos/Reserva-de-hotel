package com.example.Reserva.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Reserva de Hotel API")
                        .version("1.0.0")
                        .description("API para gerenciamento de reserva, " +
                                "incluindo cadastro, consulta e atualização de dados.")
                        .contact(new Contact()
                                .name("Rafael Feitosa")
                                .url("https://www.linkedin.com/in/rafaelfeitosa-dev/")
                                .email("rafael@hotmail.com")
                        )
                );
    }
}
