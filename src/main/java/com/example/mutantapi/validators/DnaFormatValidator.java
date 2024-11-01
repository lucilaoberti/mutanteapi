package com.example.mutantapi.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class DnaFormatValidator implements ConstraintValidator<ValidDNA, String[]> {

    private static final Set<Character> VALID_LETTERS = Set.of('A', 'G', 'T', 'C');
    @Override
    public void initialize(ValidDNA constraintAnnotation) {
    }



    @Override
public boolean isValid(String[] dnaMatrix, ConstraintValidatorContext context) {
    // Validar que el arreglo de ADN no sea nulo, no esté vacío y tenga más de 4 filas
    if (dnaMatrix == null || dnaMatrix.length < 4) {
        return false;  // El array es nulo o tiene 4 filas o menos
    }

    int size = dnaMatrix.length;  // Número de filas en la matriz

    // Verificar cada secuencia en el arreglo de ADN
    for (String sequence : dnaMatrix) {
        // Verificar que la secuencia no sea nula y que su longitud sea igual al número de filas (matriz cuadrada)
        if (sequence == null || sequence.length() != size) {
            return false;  // La matriz no es cuadrada o la secuencia es nula
        }

        // Comprobar que todos los caracteres en la secuencia sean válidos
        if (!containsValidCharacters(sequence)) {
            return false;  // Secuencia contiene caracteres inválidos
        }
    }

    return true;  // Todas las verificaciones han pasado
}


    private boolean containsValidCharacters(String sequence) {
        for (char chosenletter : sequence.toCharArray()) {
            // Si algún carácter no está en los nucleotidos permitidos, devolver false
            if (!VALID_LETTERS.contains(chosenletter)){
                return false;
            }
        }
        return true;
    }
}
