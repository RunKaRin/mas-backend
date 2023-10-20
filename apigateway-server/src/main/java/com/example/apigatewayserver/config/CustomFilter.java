package com.example.apigatewayserver.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {

    public CustomFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            // pre filter : 그냥 작성 하면 돌아감
            System.out.println("Custom pre  filter : " + request.getId());

            // post filter : return 구문 속에 코드를 작성 해야 한다.
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("Custom post filter : status code : " + response.getStatusCode());
            }));
        };
    }
    public static class Config {
    }
}
