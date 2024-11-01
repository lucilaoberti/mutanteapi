package com.example.mutantapi.domain.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Base implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id ;

}
