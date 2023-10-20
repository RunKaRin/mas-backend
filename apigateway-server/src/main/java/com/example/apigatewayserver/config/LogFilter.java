package com.example.apigatewayserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LogFilter extends AbstractGatewayFilterFactory<LogFilter.Config> {

    public LogFilter() { super(Config.class); }

    @Override
    public GatewayFilter apply(LogFilter.Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("log per filter : {}", request.getId());

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("log post filter : {}", response.getStatusCode());
            }));

        };
    }
    public static class Config { }
}
