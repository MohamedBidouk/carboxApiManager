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
                .route("odoo",r ->r
                        .path("/odoo/api/**")
                        .filters(f -> f.rewritePath("/odoo/api/(?<remains>.*)", "/api/${remains}"))
                        .uri("http://164.132.56.7:8819")
                )
                .route("s4b",r ->r
                        .path("/s4b/api/**")
                        .filters(f -> f.rewritePath("/s4b/api/(?<remains>.*)", "/api/${remains}"))
                        .uri("https://solutions4business.net")
                )
                .route("discovery-server", r -> r
                        .path("/eureka/web")
                        .filters(f -> f.setPath("/"))
                        .uri("http://localhost:8761")
                )
                .build();
    }
}
