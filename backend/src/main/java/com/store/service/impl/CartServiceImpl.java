package com.store.service.impl;

import com.store.dto.CartItemDto;
import com.store.entity.CartItem;
import com.store.entity.Product;
import com.store.exception.NotFoundException;
import com.store.repository.CartItemRepository;
import com.store.repository.ProductRepository;
import com.store.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Override
    public List<CartItemDto> getCart(String username) {
        return cartItemRepository.findByUsername(username).stream()
                .map(it -> new CartItemDto(it.getId(), it.getProduct().getId(), it.getQuantity()))
                .toList();
    }

    @Override
    public CartItemDto addToCart(String username, CartItemDto dto) {
        Product product = productRepository.findById(dto.productId()).orElseThrow(() -> new NotFoundException("Product not found"));
        CartItem cartItem = new CartItem();
        cartItem.setUsername(username);
        cartItem.setProduct(product);
        cartItem.setQuantity(dto.quantity());
        CartItem saved = cartItemRepository.save(cartItem);
        return new CartItemDto(saved.getId(), saved.getProduct().getId(), saved.getQuantity());
    }

    @Override
    public void clearCart(String username) {
        cartItemRepository.deleteByUsername(username);
    }
}
