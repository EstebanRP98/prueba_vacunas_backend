package com.erosero.kruvacunas.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openApi = new OpenAPI();
        openApi.info(
                new Info().title("KRU VACUNAS")
                        .description("Proyecto de prueba de vacunas para kruger")
                        .version("0.1")
                        .contact(new Contact()
                                .email("kruger.com.ec")
                                .name("kruger")
                                .url("kruger.com.ec"))
                        .termsOfService("")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENCE-2.0"))
        );

//        openApi.components(
//                new Components().addSecuritySchemes("bearer-jwt",
//                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
//                                .in(SecurityScheme.In.HEADER).name("Authorization"))
//        );



        return openApi;
    }


    private Info info(){
        return new Info().title("Crs")
                .description("crs proyecto")
                .version("0.1")
                .contact(new Contact()
                        .email("cognoware.com.ec")
                        .name("cognoware")
                        .url("cognoware.com.ec"))
                .termsOfService("")
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://www.apache.org/licenses/LICENCE-2.0"));
    }


}
