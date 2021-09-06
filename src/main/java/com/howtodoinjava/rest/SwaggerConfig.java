package com.howtodoinjava.rest;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Lead Spong").description("CRM").termsOfServiceUrl("https://www.linkedin.com/in/danton-issler-rodrigues-8ba01a115/")
                .contact(new Contact("Danton Issler Rodrigues", "https://www.linkedin.com/in/danton-issler-rodrigues-8ba01a115/", "danton.issler18@gmail.com")).license("Todos os direitos reservados.")
                .licenseUrl("https://www.linkedin.com/in/danton-issler-rodrigues-8ba01a115/").version("1.0.0").build();
    }
}
