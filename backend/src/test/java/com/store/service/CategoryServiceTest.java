package com.store.service;

import com.store.dto.CategoryDto;
import com.store.entity.Category;
import com.store.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
  @Mock CategoryRepository repository;
  @InjectMocks CategoryService service;

  @Test
  void createsCategory() {
    when(repository.save(any())).thenReturn(Category.builder().id(1L).name("CPU").build());
    CategoryDto result = service.create(new CategoryDto(null, "CPU"));
    assertEquals("CPU", result.name());
  }
}
