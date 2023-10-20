package com.example.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain security(HttpSecurity http) throws Exception {
//        return http
//                // 구버전
//                .authorizeRequests() // 인증, 인가 설정을 시작
//                .requestMatchers("/user-service/health-check").permitAll() // 해당 주소는 인증, 인가 없이 접속 가능
//                .anyRequest().hasRole("/ROLE_ADMIN")
//                .and()
//                .csrf()
//                .disable()
//                .build();
        return http
                // 람다식
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/**").permitAll())
                .csrf(csrfConfig -> csrfConfig
                        .disable())
                .build();
    }

    // 암호와 비밀번호 저장을 위한 BCryptEncoder 빈 생성
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
