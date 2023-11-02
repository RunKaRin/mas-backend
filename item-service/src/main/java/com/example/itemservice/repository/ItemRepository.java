package com.example.itemservice.repository;

import com.example.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

//    Item findItemByProductId(String productId);

    // productId 기준 orderList 조회
    public Optional<Item> findItemByProductId(String productId);


}
