package com.example.mutantapi.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StatsResponse {
    private long countMutantDna;
    private long countHumanDna;

    private double ratio;
}
