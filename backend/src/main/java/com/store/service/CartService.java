package com.store.service;

import com.store.dto.CartItemDto;

import java.util.List;

public interface CartService {
    List<CartItemDto> getCart(String username);
    CartItemDto addToCart(String username, CartItemDto dto);
    void clearCart(String username);
}
