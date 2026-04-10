package com.store.controller;

import com.store.dto.CartItemDto;
import com.store.service.CartService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService service;
    public CartController(CartService service) { this.service = service; }

    @GetMapping
    public List<CartItemDto> myCart(@AuthenticationPrincipal Jwt jwt) {
        return service.getCart(jwt.getSubject());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartItemDto add(@AuthenticationPrincipal Jwt jwt, @Valid @RequestBody CartItemDto dto) {
        return service.addItem(jwt.getSubject(), dto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clear(@AuthenticationPrincipal Jwt jwt) {
        service.clearCart(jwt.getSubject());
    }
}
