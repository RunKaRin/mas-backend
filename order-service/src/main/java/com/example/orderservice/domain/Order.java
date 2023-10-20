package com.example.orderservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false) // 주문코드 불변
    private String orderId;
    private Long count;
    @CreatedDate
    @Column(updatable = false) // 주문시간은 불변
    private LocalDateTime createAt;

    private String userId;
    private String productId;
}
