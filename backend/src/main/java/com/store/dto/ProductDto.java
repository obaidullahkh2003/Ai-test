package com.store.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ProductDto(Long id, @NotBlank String name, @NotNull BigDecimal price, Integer stock, @NotNull Long categoryId) { }
