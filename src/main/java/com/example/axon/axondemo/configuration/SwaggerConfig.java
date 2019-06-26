package com.example.axon.axondemo.configuration;

import com.example.axon.axondemo.controller.AccountCommandController;
import com.example.axon.axondemo.controller.AccountQueryController;
import com.example.axon.axondemo.service.AccountCommandService;
import com.example.axon.axondemo.service.AccountCommandServiceImpl;
import com.example.axon.axondemo.service.AccountQueryService;
import com.example.axon.axondemo.service.AccountQueryServiceImpl;
import org.axonframework.axonserver.connector.event.axon.AxonServerEventStore;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
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

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.example.axon.axondemo"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
            "Event Sourcing using Axon and Spring Boot",
            "App to demonstrate Event Sourcing using Axon and Spring Boot",
            "1.0.0",
            "Terms of Service",
            new Contact("Saurabh Dashora", "progressivecoder.com", "coder.progressive@gmail.com"),
            "",
            "",
            Collections.emptyList());
    }

    @Bean
    public AccountQueryService accountQueryService(EventStore eventStore) {
        return new AccountQueryServiceImpl(eventStore);
    }

    @Bean
    public AccountCommandService accountCommandService(CommandGateway commandGateway){
        return new AccountCommandServiceImpl(commandGateway);
    }

}
