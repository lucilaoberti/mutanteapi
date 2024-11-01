package com.example.mutantapi.domain.dtos;

import com.example.mutantapi.validators.ValidDNA;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DnaRequest {
    @ValidDNA
    private String[] dna;
}
