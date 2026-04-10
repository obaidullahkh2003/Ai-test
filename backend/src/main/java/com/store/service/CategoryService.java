package com.store.service;

import com.store.dto.CategoryDto;
import com.store.entity.Category;
import com.store.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
  private final CategoryRepository repository;

  public List<CategoryDto> list() { return repository.findAll().stream().map(c -> new CategoryDto(c.getId(), c.getName())).toList(); }

  public CategoryDto create(CategoryDto dto) {
    Category saved = repository.save(Category.builder().name(dto.name()).build());
    return new CategoryDto(saved.getId(), saved.getName());
  }
}
