package com.store.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record OrderDto(Long id, BigDecimal totalAmount, Instant createdAt, List<OrderLineDto> items) {
    public record OrderLineDto(Long productId, String productName, Integer quantity, BigDecimal unitPrice) {}
}
