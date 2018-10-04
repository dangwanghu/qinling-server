package com.tfssoft.qinling.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置
 * @author DWH
 * @date 2016-12-01
 */
@EnableWebMvc
@EnableSwagger2
@Configuration
public class SwaggerConfig {

   @Bean
   public Docket createRestApi() {
       return new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(apiInfo())
               .select()
               .apis(RequestHandlerSelectors.basePackage("com.tfssoft.qinling")) // 注意修改此处的包名
               .paths(PathSelectors.any())
               .build();
   }

   @SuppressWarnings("deprecation")
   private ApiInfo apiInfo() {
       return new ApiInfoBuilder()
               .title("API List v1.0.0")
               .description("大美秦岭平台")
               .termsOfServiceUrl("NO terms of service")
               .contact("dangwanghu000@126.com")
               .version("1.0.0")
               .build();
   }
}