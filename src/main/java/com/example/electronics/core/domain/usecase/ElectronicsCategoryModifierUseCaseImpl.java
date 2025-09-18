package com.example.electronics.core.domain.usecase;

import com.example.electronics.core.domain.model.ElectronicsCategoryDomainModel;
import com.example.electronics.core.domain.persistence.port.ElectronicsCategoryModifierPersistencePort;
import com.example.electronics.infradetails.persistence.mapper.ElectronicsCategoryDomainEntityMapper;
import com.example.electronics.infradetails.persistence.repository.ElectronicsCategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


public class ElectronicsCategoryModifierUseCaseImpl implements ElectronicsCategoryModifierUseCase {

    private final ElectronicsCategoryModifierPersistencePort persistencePort;

    public ElectronicsCategoryModifierUseCaseImpl(ElectronicsCategoryModifierPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }


    @Override
    public ElectronicsCategoryDomainModel createCategory(ElectronicsCategoryDomainModel category) {
        return persistencePort.saveCategory(category);
    }

    @Override
    public ElectronicsCategoryDomainModel updateCategory(Long id, ElectronicsCategoryDomainModel category) {
        return persistencePort.updateCategory(id, category);
    }

    @Override
    public ElectronicsCategoryDomainModel getCategoryById(Long id) {
        return persistencePort.findById(id);
    }

    @Override
    public List<ElectronicsCategoryDomainModel> getAllCategories() {
        return persistencePort.findAll();
    }
}
