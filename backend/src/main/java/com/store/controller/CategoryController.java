package com.store.controller;

import com.store.dto.CategoryDto;
import com.store.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
  private final CategoryService service;

  @GetMapping
  public List<CategoryDto> list() { return service.list(); }

  @PostMapping
  @PreAuthorize("hasRole('ADMIN')")
  public CategoryDto create(@RequestBody @Valid CategoryDto dto) { return service.create(dto); }
}
