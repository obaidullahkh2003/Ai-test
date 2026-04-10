package com.store.controller;

import com.store.dto.ProductDto;
import com.store.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping
    public List<ProductDto> getAll() { return service.findAll(); }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ProductDto create(@Valid @RequestBody ProductDto dto) { return service.create(dto); }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ProductDto update(@PathVariable Long id, @Valid @RequestBody ProductDto dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
