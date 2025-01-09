package ch.bbw.umsetzungsarbeit.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

  @Bean
  public RouteLocator routes(RouteLocatorBuilder builder) {
    return builder.routes()
        .route("auth-service", r -> r.path("/auth/**")
            .uri("lb://AUTH-SERVICE"))
        .route("user-service", r -> r.path("/users/**")
            .uri("lb://USER-SERVICE"))
        .route("product-service", r -> r.path("/products/**")
            .uri("lb://PRODUCT-SERVICE"))
        .route("cart-service", r -> r.path("/cart/**")
            .uri("lb://CART-SERVICE"))
        .route("order-service", r -> r.path("/orders/**")
            .uri("lb://ORDER-SERVICE"))
        .build();
  }
}
