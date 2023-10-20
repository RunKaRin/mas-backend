package com.example.userservice.dto;

import com.example.userservice.domain.Order;
import com.example.userservice.domain.User;
import lombok.*;

import java.util.List;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor @Builder @ToString
public class ResponseFindUserDto {

    // 비밀번호 및 특정 정보를 제외한 정보 조회

    private Long id;
    private String uuid;
    private String userId;
    private String name;
    private String email;

    // 필요하다면 구매내역을 같이 가져올 수 있도록 처리
    private List<Order> orderList;

    public ResponseFindUserDto(User user) {
        this.id = user.getId();
        this.uuid = user.getUuid();
        this.userId = user.getUserId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
