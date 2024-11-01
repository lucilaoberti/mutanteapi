package com.example.mutantapi.business.services;

import com.example.mutantapi.domain.dtos.StatsResponse;
import com.example.mutantapi.domain.entities.Stats;
import com.example.mutantapi.repositories.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    private HumanRepository humanRepository;
    public Stats getStats() {
        long countMutantDna = humanRepository.countByIsMutant(true);
        long countHumanDna = humanRepository.countByIsMutant(false);
        double ratio = countHumanDna == 0 ? 0 : (double) countMutantDna / countHumanDna;
        return new Stats(countMutantDna, countHumanDna, ratio);
    }
}
