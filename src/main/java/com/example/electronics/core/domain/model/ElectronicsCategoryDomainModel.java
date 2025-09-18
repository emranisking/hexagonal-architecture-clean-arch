package com.example.electronics.core.domain.model;
import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElectronicsCategoryDomainModel implements Serializable {
    private Long id;
    private String name;
    private Boolean available;
}
