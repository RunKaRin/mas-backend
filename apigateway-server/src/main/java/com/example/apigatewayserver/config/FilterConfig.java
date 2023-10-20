package com.example.apigatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
//    @Bean // 빈을 주석 처리만 해도 아래 내용을 사용 못함.
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//        return builder.routes() // 라우팅 정보 등록 시작 지점
//                .route(r -> r.path("/first-service/**")
//                            .filters(f -> f.addRequestHeader("first-service_req_h", "first-service_req_v")
//                                    .addResponseHeader("first-service_res_h", "first-service_res_v"))
//                            .uri("http://localhost:8001/")
//                ) // 개별 라우팅 정보를 등록 하는 route() 메서드
//
//                .route(r -> r.path("/second-service/**")
//                            .filters(f -> f.addRequestHeader("second-service_req_h", "second-service_req_v")
//                                    .addResponseHeader("second-service_res_h", "second-service_res_v"))
//                            .uri("http://localhost:8002/")
//                )
//                .build(); // 라우팅 정보 등록 종료 지점
//    }
}
