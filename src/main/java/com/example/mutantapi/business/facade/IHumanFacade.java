package com.example.mutantapi.business.facade;

import com.example.mutantapi.domain.dtos.DnaRequest;
import com.example.mutantapi.domain.dtos.HumanFullDto;
import com.example.mutantapi.domain.entities.Human;

public interface IHumanFacade {
     HumanFullDto crear(DnaRequest nuevohumanoDto);
}

