package com.cg.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class Config 
{
	@Bean
public RouteLocator allroutes(RouteLocatorBuilder route) {
	return route.routes()
			.route(user->user
		    .path("/user/*")
		    .uri("http://localhost:8083"))
			
			.route(Admin->Admin
			.path("/admin/*")
			.uri("http://localhost:8084"))
			
			.route(washer->washer 
			.path("/washer/*")
			.uri("http://localhost:8082"))
			
			.route(order->order 
			.path("/order/*")
			.uri("http://localhost:8083"))
			
			.route(pay->pay 
			.path("/gateway/*")
			.uri("http://localhost:1234"))
		    .build();
	
}

}
