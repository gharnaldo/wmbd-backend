package com.wmbd.backendmain.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
	@Value("${server.basePath}")
    private String serverBasePath;
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.pathProvider(new RelativePathProvider(getServletContext()) {
        	        @Override
        	        public String getApplicationBasePath() {
        	            return serverBasePath;
        	        }
        	    })
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wmbd.backendmain.controllers"))
                .paths(regex("/*.*"))
                .build()
                .apiInfo(metaData());
             
    }
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Brand Discounts Services")
                .description("Brand Discounts Services")
                .version("1.0.0")
                //.license("")
                //.licenseUrl("")
                //.contact(new Contact("Falabella", "http://www.falabella.cl", "lia@falabella.cl"))
                .build();
    }   
    
    
  @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
  
}
