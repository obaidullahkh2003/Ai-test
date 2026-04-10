package com.store.controller;

import com.store.dto.OrderDto;
import com.store.service.OrderService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service) { this.service = service; }

    @PostMapping("/checkout")
    public OrderDto checkout(@AuthenticationPrincipal Jwt jwt) {
        return service.checkout(jwt.getSubject());
    }

    @GetMapping("/me")
    public List<OrderDto> myOrders(@AuthenticationPrincipal Jwt jwt) {
        return service.myOrders(jwt.getSubject());
    }
}
