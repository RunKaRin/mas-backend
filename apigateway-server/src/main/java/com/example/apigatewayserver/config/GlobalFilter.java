package com.example.apigatewayserver.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {

    public GlobalFilter() { super(Config.class); }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            // pre filter : 그냥 작성 하면 돌아감
            System.out.println("global filter default message : " + config.getMessage());

            // pre에서 사용할지 말지 불린값으로 판단한다
            if (config.isPre()) {
                System.out.println("global pre  filter : " + request.getId());
            }

            // post filter : return 구문 속에 코드를 작성 해야 한다.
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if(config.isPost()) {
                    System.out.println("global post filter : " + response.getStatusCode());
                }
            }));
        });
    }
    @Getter
    @Setter
    public static class Config {
        private String message;
        private boolean pre;
        private boolean post;
    }
}
