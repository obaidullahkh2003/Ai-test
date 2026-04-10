package com.store.controller;

import com.store.entity.Order;
import com.store.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;

    @GetMapping
    public List<Order> list() { return orderRepository.findAll(); }

    @PostMapping
    public Order checkout(@RequestBody Order order) { return orderRepository.save(order); }
}
