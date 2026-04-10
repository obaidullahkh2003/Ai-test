package com.store.service;

import com.store.dto.CategoryDto;
import com.store.entity.Category;
import com.store.exception.NotFoundException;
import com.store.mapper.CategoryMapper;
import com.store.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryService(CategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CategoryDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public Category getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
    }

    public CategoryDto create(CategoryDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public CategoryDto update(Long id, CategoryDto dto) {
        Category category = getById(id);
        category.setName(dto.name());
        category.setDescription(dto.description());
        return mapper.toDto(repository.save(category));
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
