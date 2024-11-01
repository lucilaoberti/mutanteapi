package com.example.mutantapi.business.mapper;

import com.example.mutantapi.domain.dtos.StatsResponse;
import com.example.mutantapi.domain.entities.Stats;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatsMapper {
 // HumanFullDto humanToHumanFullDto(Human human);
  StatsResponse StatstoStatsResponse(Stats stats);
}
