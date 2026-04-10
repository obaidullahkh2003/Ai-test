package com.store.controller;

import com.store.entity.CartItem;
import com.store.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartItemRepository cartItemRepository;

    @GetMapping("/{customerId}")
    public List<CartItem> getCart(@PathVariable String customerId) {
        return cartItemRepository.findByCustomerId(customerId);
    }

    @PostMapping
    public CartItem addItem(@RequestBody CartItem item) { return cartItemRepository.save(item); }

    @DeleteMapping("/{customerId}")
    public void clear(@PathVariable String customerId) { cartItemRepository.deleteByCustomerId(customerId); }
}
