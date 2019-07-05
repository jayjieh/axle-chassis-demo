package com.axle.chassisdemo.demo.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${server.servlet.context-path}")
    private String baseUrl;
    @Value("${spring.application.name}")
    private String appName;
    @Value("${app.params.application.description}")
    private String appDesc;
    @Value("${app.params.application.version}")
    private String version;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(Predicates.not(PathSelectors.regex("/auditevents.*|/error|/autoconfig.*|/beans.*"
                        + "|/configprops.*|/dump.*|/features.*|/info.*|/mapping.*|/trace.*|/env.*|/pause.*"
                        + "|/refresh.*|/resume.*|/heapdump.*|/loggers.*|/restart.*|/oauth/error")))
                .build()
                .apiInfo(apiInfo())
                .globalResponseMessage(RequestMethod.GET, newArrayList(
                        new ResponseMessageBuilder().code(500).message("Internal Server Error")
                                .responseModel(new ModelRef("Error"))
                                .build()
                ))
                .securitySchemes(newArrayList(oauthScheme()))
                ;
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(appName)
                .description(appDesc)
                .version(version)
                .build()
                ;
    }

    @Bean
    public SecurityScheme oauthScheme() {
        List<GrantType> grantTypes = new ArrayList<>();
        String tokenUrl = baseUrl + "/oauth/token";
        GrantType clientGrantType = new ClientCredentialsGrant(tokenUrl);
        grantTypes.add(clientGrantType);
        GrantType passwordGrantType = new ResourceOwnerPasswordCredentialsGrant(tokenUrl);
        grantTypes.add(passwordGrantType);

        return new OAuthBuilder()
                .name("aSwaggerClient")
                .grantTypes(grantTypes)
                .build();
    }

}
