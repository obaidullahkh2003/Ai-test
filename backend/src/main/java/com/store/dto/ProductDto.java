package com.store.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ProductDto(
        Long id,
        @NotBlank String name,
        String description,
        @NotNull @Min(0) BigDecimal price,
        @NotNull @Min(0) Integer stock,
        @NotNull Long categoryId
) {}
