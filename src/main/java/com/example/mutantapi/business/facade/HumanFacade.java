package com.example.mutantapi.business.facade;

import com.example.mutantapi.business.mapper.HumanMapper;
import com.example.mutantapi.business.services.HumanService;
import com.example.mutantapi.domain.dtos.DnaRequest;
import com.example.mutantapi.domain.dtos.HumanFullDto;
import com.example.mutantapi.domain.entities.Human;
import com.example.mutantapi.repositories.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumanFacade {
    @Autowired
    private HumanMapper humanMapper;

    @Autowired
    private HumanService humanService;

    public HumanFullDto crear( DnaRequest nuevoHumanoDto) {
      // Convertir el Dto en una Entidad
        var newHuman = humanMapper.DnaRequesTtoToHuman(nuevoHumanoDto);
        // Guardar la entidad
        boolean isMutant = humanService.analyzeDna(newHuman.getDna());
        var humanGuardado = humanService.crear(newHuman);

        // Devolver la nueva entidad convertida en Dto
        return humanMapper.humanToHumanFullDto(humanGuardado);
    }

}