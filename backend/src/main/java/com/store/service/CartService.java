package com.store.service;

import com.store.domain.CartItem;
import com.store.dto.AddCartItemRequest;
import com.store.dto.OrderItemDto;
import com.store.mapper.StoreMapper;
import com.store.repository.CartItemRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartItemRepository cartItemRepository;
    private final ProductService productService;
    private final StoreMapper mapper;

    public CartService(CartItemRepository cartItemRepository, ProductService productService, StoreMapper mapper) {
        this.cartItemRepository = cartItemRepository;
        this.productService = productService;
        this.mapper = mapper;
    }

    public void add(String customerId, AddCartItemRequest request) {
        CartItem item = new CartItem();
        item.setCustomerId(customerId);
        item.setProduct(productService.getById(request.productId()));
        item.setQuantity(request.quantity());
        cartItemRepository.save(item);
    }

    public List<OrderItemDto> get(String customerId) {
        return cartItemRepository.findByCustomerId(customerId).stream().map(mapper::toDto).toList();
    }

    public List<CartItem> getRaw(String customerId) {
        return cartItemRepository.findByCustomerId(customerId);
    }

    public void clear(String customerId) {
        cartItemRepository.deleteByCustomerId(customerId);
    }
}
