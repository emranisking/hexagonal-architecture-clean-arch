package com.example.electronics.infradetails.persistence.repository;
import com.example.electronics.infradetails.persistence.entity.ElectronicsCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectronicsCategoryRepository extends JpaRepository<ElectronicsCategoryEntity, Long> {

    boolean existsByName(String name);
}
