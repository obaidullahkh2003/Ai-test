package com.store.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductDto(Long id, @NotBlank String name, String description, @NotNull @Positive BigDecimal price,
                         @NotNull @Min(0) Integer stock, Long categoryId, String categoryName) {}
