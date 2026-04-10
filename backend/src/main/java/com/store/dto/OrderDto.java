package com.store.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record OrderDto(Long id, Instant createdAt, BigDecimal total, List<OrderItemDto> items) {}
