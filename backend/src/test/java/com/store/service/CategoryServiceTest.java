package com.store.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.store.domain.Category;
import com.store.mapper.StoreMapper;
import com.store.repository.CategoryRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

class CategoryServiceTest {

    private final CategoryRepository repo = Mockito.mock(CategoryRepository.class);
    private final StoreMapper mapper = Mappers.getMapper(StoreMapper.class);
    private final CategoryService service = new CategoryService(repo, mapper);

    @Test
    void shouldReturnAllCategories() {
        Category category = new Category();
        category.setId(1L);
        category.setName("CPU");
        when(repo.findAll()).thenReturn(List.of(category));

        assertEquals(1, service.findAll().size());
    }
}
