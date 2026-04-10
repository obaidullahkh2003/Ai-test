package com.store.controller;

import com.store.dto.AddCartItemRequest;
import com.store.dto.OrderItemDto;
import com.store.service.CartService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<OrderItemDto> getCart(JwtAuthenticationToken auth) {
        return cartService.get(auth.getToken().getSubject());
    }

    @PostMapping
    public void addToCart(@Valid @RequestBody AddCartItemRequest request, JwtAuthenticationToken auth) {
        cartService.add(auth.getToken().getSubject(), request);
    }
}
