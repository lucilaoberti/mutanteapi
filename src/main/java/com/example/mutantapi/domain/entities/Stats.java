package com.example.mutantapi.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Stats {

    private long countMutantDna;
    private long countHumanDna;

    private double ratio;
}
