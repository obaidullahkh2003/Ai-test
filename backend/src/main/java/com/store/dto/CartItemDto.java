package com.store.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CartItemDto(Long id, @NotNull Long productId, @Min(1) Integer quantity) {}
