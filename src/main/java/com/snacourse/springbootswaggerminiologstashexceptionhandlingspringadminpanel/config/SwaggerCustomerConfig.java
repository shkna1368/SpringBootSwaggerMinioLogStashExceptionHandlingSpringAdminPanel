package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.config;


import com.fasterxml.classmate.TypeResolver;
import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model.Archive;
import com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.model.ArchiveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableSwagger2
public class SwaggerCustomerConfig {
    @Autowired
    private TypeResolver typeResolver;
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .additionalModels( typeResolver.resolve(Archive.class),
                                   typeResolver.resolve(ArchiveDTO.class))

                .select()

                .apis(RequestHandlerSelectors.basePackage("com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())            .globalOperationParameters(
                        Arrays.asList(new ParameterBuilder()
                                .name("Authorization")
                                .description("Autorizatiom Header")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .build()))
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SnaCourse-Tutorial")
                .description("Api Documentation")
                .version("version 1.0.0")
                .build();
    }


}