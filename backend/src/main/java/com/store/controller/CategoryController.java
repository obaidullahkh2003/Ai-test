package com.store.controller;

import com.store.entity.Category;
import com.store.repository.CategoryRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> list() { return categoryRepository.findAll(); }

    @PostMapping
    public Category create(@Valid @RequestBody Category category) { return categoryRepository.save(category); }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return categoryRepository.save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { categoryRepository.deleteById(id); }
}
