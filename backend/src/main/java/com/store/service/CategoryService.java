package com.store.service;

import com.store.domain.Category;
import com.store.dto.CategoryDto;
import com.store.exception.NotFoundException;
import com.store.mapper.StoreMapper;
import com.store.repository.CategoryRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final StoreMapper mapper;

    public CategoryService(CategoryRepository categoryRepository, StoreMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(mapper::toDto).toList();
    }

    public CategoryDto create(CategoryDto dto) {
        Category c = new Category();
        c.setName(dto.name());
        return mapper.toDto(categoryRepository.save(c));
    }

    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) throw new NotFoundException("Category not found");
        categoryRepository.deleteById(id);
    }

    public Category getRef(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
    }
}
