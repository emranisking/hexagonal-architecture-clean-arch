package com.example.electronics.core.domain.persistence.port;
import com.example.electronics.core.domain.model.ElectronicsCategoryDomainModel;
import java.util.List;

public interface ElectronicsCategoryModifierPersistencePort {

    ElectronicsCategoryDomainModel saveCategory(ElectronicsCategoryDomainModel categoryDomainModel);

    ElectronicsCategoryDomainModel updateCategory(Long id, ElectronicsCategoryDomainModel categoryDomainModel);

    ElectronicsCategoryDomainModel findById(Long id);

    List<ElectronicsCategoryDomainModel> findAll();
}
