package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.category.CategoryCreateDTO;
import org.example.dto.category.CategoryItemDTO;
import org.example.entities.CategoryEntity;
import org.example.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;
    @GetMapping("/")
    public ResponseEntity<List<CategoryItemDTO>> index() {
        var result = new ArrayList<CategoryItemDTO>();
        var item = new CategoryItemDTO();
        item.setId(1);
        item.setName("Сало");;
        item.setDescription("Для козаків");
        result.add(item);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/api/category")
    public CategoryEntity create(@RequestBody CategoryCreateDTO dto) {
        CategoryEntity entity = new CategoryEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        categoryRepository.save(entity);
        return entity;
    }
}
