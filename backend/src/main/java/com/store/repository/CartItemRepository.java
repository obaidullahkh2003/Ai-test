package com.store.repository;

import com.store.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCustomerId(String customerId);
    void deleteByCustomerId(String customerId);
}
