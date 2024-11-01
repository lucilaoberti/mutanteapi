package com.example.mutantapi.validators;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class DnaFormatValidatorTest {
    DnaFormatValidator validator = new DnaFormatValidator();
    // Validacion de secuencia de caracteres
    @Test
public void testDnaValidatorcaracteresinvalidos() {

    String[] invalidDna = {"ATGC", "CTGA", "TGXA", "GATT"};  // 'X' es un carácter inválido
    boolean result = validator.isValid(invalidDna, null);
    assertFalse(result, "El validador debería devolver false cuando hay caracteres inválidos.");
}
//Secuecias insufientes para un mutante
    @Test
 public void testInvalidTableSize() {
    String[] dna = {"AAA", "GCG", "GTA"};  // La longitud de cada secuencia no coincide con el tamaño esperado de la matriz
    assertFalse(validator.isValid(dna, null), "La validación debería fallar cuando las secuencias tienen una longitud incorrecta.");
}
//Validacion matriz no cuadrada
    @Test
public void testNonSquareDnaMatrix4x5() {
    String[] dna = {
        "ATGCA",
        "CGTAC",
        "TTAGG",
        "GGCAT"
    };  // Matriz de 4x5 (no cuadrada)
    assertFalse(validator.isValid(dna, null), "La validación debería fallar cuando la matriz de ADN no es cuadrada (ej. 4x5).");
}
//Validacion matriz nula
    @Test
public void testNullMatrix() {
    assertFalse(validator.isValid(null, null));
}
// Uno nulo
    @Test
public void testMatrixWithNullRow() {
    String[] dnaMatrix = {"ATGC", null, "TGCA", "GATC"};
    assertFalse(validator.isValid(dnaMatrix, null));
}
//matriz 4x4
    @Test
public  void testValidMatrix() {
    String[] dnaMatrix = {"ATGC", "CAGT", "TGCA", "GATC"};
    assertTrue(validator.isValid(dnaMatrix, null));
}
// matriz tamaño insufieciente
    @Test
    public  void testMatrixTooSmall() {
    String[] dnaMatrix = {"ATGC", "CAGT"};
    assertFalse(validator.isValid(dnaMatrix, null));
}


}
