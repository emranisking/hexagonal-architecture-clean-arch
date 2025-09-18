package com.example.electronics.core.domain.usecase;
import com.example.electronics.core.domain.model.ElectronicsCategoryDomainModel;
import java.util.List;

public interface ElectronicsCategoryModifierUseCase {

    ElectronicsCategoryDomainModel createCategory(ElectronicsCategoryDomainModel categoryDomainModel);

    ElectronicsCategoryDomainModel updateCategory(Long id, ElectronicsCategoryDomainModel categoryDomainModel);

    ElectronicsCategoryDomainModel getCategoryById(Long id);

    List<ElectronicsCategoryDomainModel> getAllCategories();
}
