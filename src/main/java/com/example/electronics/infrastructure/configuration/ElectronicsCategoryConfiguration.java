package com.example.electronics.infrastructure.configuration;

import com.example.electronics.core.domain.persistence.port.ElectronicsCategoryModifierPersistencePort;
import com.example.electronics.core.domain.usecase.ElectronicsCategoryModifierUseCase;
import com.example.electronics.core.domain.usecase.ElectronicsCategoryModifierUseCaseImpl;
import com.example.electronics.infradetails.persistence.adapter.ElectronicsCategoryModifierPersistencePortImpl;
import com.example.electronics.infradetails.persistence.mapper.ElectronicsCategoryDomainEntityMapper;
import com.example.electronics.infradetails.persistence.repository.ElectronicsCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElectronicsCategoryConfiguration {
    private final ElectronicsCategoryRepository repository;
    private final ElectronicsCategoryDomainEntityMapper mapper;
    public ElectronicsCategoryConfiguration(ElectronicsCategoryRepository repository,
                                            ElectronicsCategoryDomainEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Bean
    public ElectronicsCategoryModifierPersistencePort electronicsCategoryModifierPersistencePort() {
        return new ElectronicsCategoryModifierPersistencePortImpl(repository, mapper);
    }

    @Bean
    public ElectronicsCategoryModifierUseCase electronicsCategoryModifierUseCase() {
        return new ElectronicsCategoryModifierUseCaseImpl(electronicsCategoryModifierPersistencePort());
    }
}
