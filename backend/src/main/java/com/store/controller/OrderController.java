package com.store.controller;

import com.store.dto.OrderDto;
import com.store.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping("/checkout")
    public OrderDto checkout(@AuthenticationPrincipal Jwt jwt) { return service.checkout(jwt.getSubject()); }

    @GetMapping
    public List<OrderDto> orders(@AuthenticationPrincipal Jwt jwt) { return service.myOrders(jwt.getSubject()); }
}
