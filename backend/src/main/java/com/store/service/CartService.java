package com.store.service;

import com.store.dto.CartItemDto;
import com.store.entity.CartItem;
import com.store.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartItemRepository repository;
    private final ProductService productService;

    public CartService(CartItemRepository repository, ProductService productService) {
        this.repository = repository;
        this.productService = productService;
    }

    public List<CartItemDto> getCart(String customerId) {
        return repository.findByCustomerId(customerId).stream()
                .map(item -> new CartItemDto(item.getId(), item.getProduct().getId(), item.getQuantity()))
                .toList();
    }

    public CartItemDto addItem(String customerId, CartItemDto dto) {
        CartItem item = new CartItem();
        item.setCustomerId(customerId);
        item.setProduct(productService.getById(dto.productId()));
        item.setQuantity(dto.quantity());
        item = repository.save(item);
        return new CartItemDto(item.getId(), item.getProduct().getId(), item.getQuantity());
    }

    public void clearCart(String customerId) {
        repository.deleteByCustomerId(customerId);
    }

    public List<CartItem> getCartEntities(String customerId) {
        return repository.findByCustomerId(customerId);
    }
}
