package com.carbox.apimanager.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routing {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder locatorBuilder){
        return locatorBuilder.routes()
                .route("car",r ->r
                        .path("/eureka/")
                        .uri("http://localhost:8761")
                )
                .route("discovery-server", r -> r
                        .path("/eureka/web")
                        .filters(f -> f.setPath("/"))
                        .uri("http://localhost:8761")
                )
                .build();
    }
}
