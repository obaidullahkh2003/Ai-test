package com.store.controller;

import com.store.dto.OrderDto;
import com.store.service.OrderService;
import java.util.List;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/checkout")
    public OrderDto checkout(JwtAuthenticationToken auth) {
        return orderService.checkout(auth.getToken().getSubject());
    }

    @GetMapping
    public List<OrderDto> myOrders(JwtAuthenticationToken auth) {
        return orderService.getOrders(auth.getToken().getSubject());
    }
}
