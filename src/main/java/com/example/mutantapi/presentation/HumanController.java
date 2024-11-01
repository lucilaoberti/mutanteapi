package com.example.mutantapi.presentation;

import com.example.mutantapi.business.facade.HumanFacade;
import com.example.mutantapi.domain.dtos.DnaRequest;
import com.example.mutantapi.domain.dtos.HumanFullDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping(path="api/v1/human")
public class HumanController {
    @Autowired
    private HumanFacade humanFacade;

    @PostMapping("")
    // Se espera que el cuerpo de la solicitud contenga un objeto JSON que se deserializa a PersonaFullDto.
    public ResponseEntity<HumanFullDto> crear(@Valid @RequestBody DnaRequest dnaRequest) {

        // Llama al facade para crear el humano y almacena el resultado
        HumanFullDto createdHuman = humanFacade.crear(dnaRequest);

        // Verifica si el humano es mutante
        if (createdHuman.getIsMutant()) {
            return ResponseEntity.ok(createdHuman); // Devuelve HTTP 200 OK con el objeto creado
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build(); // Devuelve HTTP 403 Forbidden


        }
    }
}