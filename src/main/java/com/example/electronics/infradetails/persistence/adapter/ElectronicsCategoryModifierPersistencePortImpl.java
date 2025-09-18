package com.example.electronics.infradetails.persistence.adapter;


import com.example.electronics.core.domain.model.ElectronicsCategoryDomainModel;
import com.example.electronics.core.domain.persistence.port.ElectronicsCategoryModifierPersistencePort;
import com.example.electronics.infradetails.persistence.entity.ElectronicsCategoryEntity;
import com.example.electronics.infradetails.persistence.mapper.ElectronicsCategoryDomainEntityMapper;
import com.example.electronics.infradetails.persistence.repository.ElectronicsCategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


public class ElectronicsCategoryModifierPersistencePortImpl implements ElectronicsCategoryModifierPersistencePort {
    private final ElectronicsCategoryRepository repository;
    private final ElectronicsCategoryDomainEntityMapper mapper;

    public ElectronicsCategoryModifierPersistencePortImpl(ElectronicsCategoryRepository repository,
                                                          ElectronicsCategoryDomainEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public ElectronicsCategoryDomainModel saveCategory(ElectronicsCategoryDomainModel categoryDomainModel) {
        ElectronicsCategoryEntity saved = repository.save(mapper.domainModelToEntity(categoryDomainModel));
        return mapper.entityToDomainModel(saved);
    }

    @Override
    public ElectronicsCategoryDomainModel updateCategory(Long id, ElectronicsCategoryDomainModel categoryDomainModel) {
        ElectronicsCategoryEntity existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ElectronicsCategory not found"));

        // ✅ MapStruct updates the existing entity in-place
        mapper.partialUpdate(categoryDomainModel, existing);

        ElectronicsCategoryEntity saved = repository.save(existing);
        return mapper.entityToDomainModel(saved);
    }


    @Override
    public ElectronicsCategoryDomainModel findById(Long id) {
        return repository.findById(id)
                .map(mapper::entityToDomainModel)
                .orElseThrow(() -> new RuntimeException("ElectronicsCategory not found"));
    }

    @Override
    public List<ElectronicsCategoryDomainModel> findAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDomainModel)
                .collect(Collectors.toList());
    }
}
