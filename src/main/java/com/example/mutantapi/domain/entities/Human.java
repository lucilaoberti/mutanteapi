package com.example.mutantapi.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="Human")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Human extends Base  {
    private Long id ;
    private String[] dna;
    private Boolean isMutant ;
}
