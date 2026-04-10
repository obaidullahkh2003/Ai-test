package com.store.dto;

import com.store.domain.OrderStatus;
import java.time.Instant;
import java.util.List;

public record OrderDto(Long id, String customerId, OrderStatus status, Instant createdAt, List<OrderItemDto> items) {}
