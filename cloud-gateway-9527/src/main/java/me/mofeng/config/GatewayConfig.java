package me.mofeng.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mofeng
 * @date 2021/9/22 14:49
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocator) {
        RouteLocatorBuilder.Builder routes = routeLocator.routes();

        routes.route("path_route_mofeng", r-> r.path("/guonei").uri("http://news.baidu.com/guonei"));

        return  routes.build();
    }
}
