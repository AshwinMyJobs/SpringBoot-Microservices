package com.apigateway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableDiscoveryClient
@CrossOrigin(origins = "http://localhost:4200")
public class EamapigatewayApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EamapigatewayApplication.class, args);
		System.setProperty("spring.config.name", "application");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("EamapigatewayApplication has been called......");
		
	}

//	@Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//                // adding 2 rotes to first microservice as we need to log request body if method is POST
//        return builder.routes()
//                .route("user-service",r -> r.path("/employee")
//                        .and().method("GET")
//                        .and().readBody(String.class, s -> true)
//                        .uri("http://localhost:8080"))
////                .route("first-microservice",r -> r.path("/first")
////                        .and().method("GET").filters(f-> f.filters(authFilter))
////                        .uri("http://localhost:8081"))
////                .route("second-microservice",r -> r.path("/second")
////                        .and().method("POST")
////                        .and().readBody(Company.class, s -> true).filters(f -> f.filters(requestFilter, authFilter))
////                        .uri("http://localhost:8082"))
////                .route("second-microservice",r -> r.path("/second")
////                        .and().method("GET").filters(f-> f.filters(authFilter))
////                        .uri("http://localhost:8082"))
////                .route("auth-server",r -> r.path("/login")
////                        .uri("http://localhost:8088"))
//                .build();
//    }
}
