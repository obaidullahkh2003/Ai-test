package com.store.service.impl;

import com.store.dto.CategoryDto;
import com.store.entity.Category;
import com.store.exception.NotFoundException;
import com.store.mapper.CategoryMapper;
import com.store.repository.CategoryRepository;
import com.store.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public List<CategoryDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public CategoryDto create(CategoryDto dto) {
        Category entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public CategoryDto update(Long id, CategoryDto dto) {
        Category category = repository.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
        category.setName(dto.name());
        return mapper.toDto(repository.save(category));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
