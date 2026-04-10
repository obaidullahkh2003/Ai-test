package com.store.service;

import com.store.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto create(CategoryDto dto);
    CategoryDto update(Long id, CategoryDto dto);
    void delete(Long id);
}
