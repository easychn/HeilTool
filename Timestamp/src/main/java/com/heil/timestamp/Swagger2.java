package com.heil.timestamp;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Jason <1878566968@qq.com>
 * @version 0.0.1 
 * @github https://github.com/orgs/heil-coder
 */
@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")     //swagger.properties 引入
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.heil.timestamp.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("密码生成器API")
                .description("SpringBoot练手小工具")
                .termsOfServiceUrl("https://github.com/orgs/heil-coder")
                .version("0.0.1")
                .build();
    }

}
