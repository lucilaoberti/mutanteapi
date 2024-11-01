package com.example.mutantapi.business.facade;

import com.example.mutantapi.business.mapper.StatsMapper;
import com.example.mutantapi.business.services.StatsService;
import com.example.mutantapi.domain.dtos.StatsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsFacade {
   @Autowired
   private StatsService statsService;
   @Autowired
   private StatsMapper statsMapper ;
    public StatsResponse getstats() {
        var newstats = statsService.getStats();
        //return humanMapper.humanToHumanFullDto(humanGuardado);
        return statsMapper.StatstoStatsResponse(newstats);
    }
}
