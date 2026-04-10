package com.store.controller;

import com.store.dto.CartItemDto;
import com.store.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService service;

    @GetMapping
    public List<CartItemDto> getCart(@AuthenticationPrincipal Jwt jwt) { return service.getCart(jwt.getSubject()); }

    @PostMapping
    public CartItemDto add(@AuthenticationPrincipal Jwt jwt, @Valid @RequestBody CartItemDto dto) { return service.addToCart(jwt.getSubject(), dto); }

    @DeleteMapping
    public void clear(@AuthenticationPrincipal Jwt jwt) { service.clearCart(jwt.getSubject()); }
}
