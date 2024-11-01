package com.example.mutantapi.business.mapper;

import com.example.mutantapi.domain.dtos.DnaRequest;
import com.example.mutantapi.domain.dtos.HumanFullDto;
import com.example.mutantapi.domain.entities.Human;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface HumanMapper {
    // Convierte de entidad a DTO

    HumanFullDto humanToHumanFullDto(Human human);

    // Convierte de DTO a entidad
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isMutant", ignore = true)
    Human DnaRequesTtoToHuman(DnaRequest dnaRequest);
}