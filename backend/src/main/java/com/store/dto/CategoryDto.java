package com.store.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryDto(Long id, @NotBlank String name, String description) {}
