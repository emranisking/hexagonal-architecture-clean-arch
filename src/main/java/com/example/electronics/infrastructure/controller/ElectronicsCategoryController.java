package com.example.electronics.infrastructure.controller;


import com.example.electronics.core.domain.model.ElectronicsCategoryDomainModel;
import com.example.electronics.core.domain.usecase.ElectronicsCategoryModifierUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/el")
public class ElectronicsCategoryController {

    private final ElectronicsCategoryModifierUseCase useCase;

    public ElectronicsCategoryController(ElectronicsCategoryModifierUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/add")
    public ResponseEntity<ElectronicsCategoryDomainModel> create(@RequestBody ElectronicsCategoryDomainModel category) {
        return ResponseEntity.ok(useCase.createCategory(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElectronicsCategoryDomainModel> update(@PathVariable Long id, @RequestBody ElectronicsCategoryDomainModel category) {
        return ResponseEntity.ok(useCase.updateCategory(id, category));
    }

    @GetMapping
    public ResponseEntity<List<ElectronicsCategoryDomainModel>> getAll() {
        return ResponseEntity.ok(useCase.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectronicsCategoryDomainModel> getById(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.getCategoryById(id));
    }
}
