package es.luis.prueba.adapter.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.example.notes"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo());
    }

   /* @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
//                .apiInfo(this.apiInfo());
    }*/
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "REST API",
                "REST API de ejemplo",
                "v1.0",
                "Todos los derechos otorgados",
                new Contact("Luis Escalante", "https://xyz.com", "luis.escalante3091@gmail.com"),
                "Licencia del API", "http://www.luis.org", Collections.emptyList());
    }

}