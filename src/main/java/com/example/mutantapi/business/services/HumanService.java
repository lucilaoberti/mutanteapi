package com.example.mutantapi.business.services;

import com.example.mutantapi.domain.entities.Human;
import com.example.mutantapi.repositories.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HumanService {

    private static final int SEQUENCE_LENGTH = 4;
    @Autowired
    private HumanRepository humanRepository;

    private static final int SEQUENCIA_MUTANTE_LENGTH = 4;
    private static final int TOTAL_SECUENCE_NEEDED= 2;



    // Verifica si el ADN ya fue analizado y devuelve el resultado si es asi
    public boolean analyzeDna(String[] dna) {
        Optional<Human> existingDna = humanRepository.findByDna(dna);
        if (existingDna.isPresent()) {
            return existingDna.get().getIsMutant();
        }
        return isMutant(dna);
    }

   // Determina si el ADN pertenece a un mutante
public static boolean isMutant(String[] dna) {
    int n = dna.length;
    int foundsecuence = 0;
    for (int i = 0; i < n; i++) {
        if (foundsecuence >= TOTAL_SECUENCE_NEEDED) {
            return true;
        }
        foundsecuence += verificarHorizontal(dna, i, n);
        foundsecuence += verificarVertical(dna, i, n);
        foundsecuence += verificarDiagonal(dna, i, n);
        foundsecuence += verificarAntiDiagonal(dna, i, n);
    }
    return foundsecuence >= TOTAL_SECUENCE_NEEDED;
}

private static int verificarHorizontal(String[] dna, int i, int n) {
    int contadordesecuecia = 0;
    int count = 1;
    for (int j = 1; j < n; j++) {
        if (dna[i].charAt(j) == dna[i].charAt(j - 1)) {
            count++;
            if (count == SEQUENCE_LENGTH) {
                contadordesecuecia++;
            }
        } else {
            count = 1;
        }
    }
    return contadordesecuecia;
}

private static int verificarVertical(String[] dna, int i, int n) {
    int contadordesecuecia = 0;
    int count = 1;
    for (int j = 1; j < n; j++) {
        if (dna[j].charAt(i) == dna[j - 1].charAt(i)) {
            count++;
            if (count == SEQUENCE_LENGTH) {
                contadordesecuecia++;
            }
        } else {
            count = 1;
        }
    }
    return contadordesecuecia;
}

private static int verificarDiagonal(String[] dna, int i, int n) {
    int contadordesecuencia = 0;
    int count = 1;
    for (int k = 1; k < n - i; k++) {
        if (dna[i + k].charAt(k) == dna[i + k - 1].charAt(k - 1)) {
            count++;
            if (count == SEQUENCE_LENGTH) {
                contadordesecuencia++;
            }
        } else {
            count = 1;
        }
    }
    return contadordesecuencia;
}

private static int verificarAntiDiagonal(String[] dna, int i, int n) {
    int contadordesecuencia = 0;
    int count = 1;
    for (int k = 1; k < n - i; k++) {
        if (dna[i + k].charAt(n - k - 1) == dna[i + k - 1].charAt(n - k)) {
            count++;
            if (count == SEQUENCE_LENGTH) {
                contadordesecuencia++;
            }
        } else {
            count = 1;
        }
    }
    return contadordesecuencia;
}


    // Guarda el humano con el resultado de si es mutante o no
    public Human crear(Human humano) {
        boolean isMutant = isMutant(humano.getDna());
        humano.setIsMutant(isMutant);
        return humanRepository.save(humano);
    }
}
