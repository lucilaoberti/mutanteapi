package com.example.mutantapi.presentation;

import com.example.mutantapi.business.facade.HumanFacade;
import com.example.mutantapi.business.facade.StatsFacade;
import com.example.mutantapi.domain.dtos.StatsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    private StatsFacade statsFacade;

    @GetMapping
    public StatsResponse getStats() {
        return statsFacade.getstats();
    }
}
