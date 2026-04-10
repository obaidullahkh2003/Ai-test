package com.store.repository;

import com.store.domain.CartItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCustomerId(String customerId);
    void deleteByCustomerId(String customerId);
}
