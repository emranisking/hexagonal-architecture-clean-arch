package com.example.electronics.infradetails.persistence.mapper;

import com.example.electronics.core.domain.model.ElectronicsCategoryDomainModel;
import com.example.electronics.infradetails.persistence.entity.ElectronicsCategoryEntity;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ElectronicsCategoryDomainEntityMapper {

    ElectronicsCategoryEntity domainModelToEntity(ElectronicsCategoryDomainModel domainModel);

    ElectronicsCategoryDomainModel entityToDomainModel(ElectronicsCategoryEntity entity);

    List<ElectronicsCategoryDomainModel> entityListToDomainList(List<ElectronicsCategoryEntity> entities);

    List<ElectronicsCategoryEntity> domainListToEntityList(List<ElectronicsCategoryDomainModel> domainModels);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(ElectronicsCategoryDomainModel domainModel, @MappingTarget ElectronicsCategoryEntity entity);
}
