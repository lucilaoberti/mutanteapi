# Parcial Magneto - Sistema de Detección de Mutantes



Este proyecto implementa un programa que analiza secuencias de ADN y determina si un humano es mutante. La detección se realiza mediante un método que identifica patrones específicos en una matriz de ADN.

## Firma del Método

Para la detección, el programa utiliza el siguiente método:

```java
boolean isMutant(String[] dna)
```

Este método recibe un array de cadenas (`String[]`), donde cada elemento representa una fila en una matriz (NxN) que contiene la secuencia de ADN. Cada cadena solo puede incluir las letras **A, T, C,** o **G**, que representan las bases nitrogenadas.

## Funcionamiento

Se considera que un humano es mutante si en la matriz de ADN se encuentran **más de una secuencia de cuatro letras idénticas** en alguna de estas direcciones:

- **Horizontal**
- **Vertical**
- **Diagonal**

El sistema carga la matriz a partir de entradas del usuario y luego aplica el algoritmo para identificar si hay secuencias de mutantes.

### Ejemplo de Entrada

Cada fila de la matriz de ADN se ingresa como una cadena de texto. Por ejemplo:
```plaintext
ATCGTA
```

### Ejemplos de Matrices de ADN

- **Matriz Mutante**:
  ```json
  {
      "dna": [
   "ATGCGA",
    "CAGTGC",
    "TTATGT",
    "AGAAGG",
    "CCCCTA",
    "TCACTG"
      ]
  }
  ```

- **Matriz No Mutante**:
  ```json
  {
      "dna": [
          "ATGGTG",
          "GTCTTA",
          "AATTGG",
          "ACTAGT",
          "GGATTC",
          "AGGCAA"
      ]
  }
  ```

## Ejecución y Acceso

Este proyecto está disponible como una API REST hosteada en [Render](https://mutanteapi.onrender.com), donde se puede verificar si un ADN pertenece a un mutante o no y consultar estadísticas de ADN.

### Endpoints Disponibles

#### `POST api/v1/human`
Verifica si la secuencia de ADN ingresada pertenece a un mutante.

- **Formato de solicitud**:
  ```json
  {
      "dna": [
          "ATGCGA",
          "CAGTGC",
          "TTATGT",
          "AGAAGG",
          "CCCCTA",
          "TCACTG"
      ]
  }
  ```
- **Respuestas**:
  - **200 OK**: El ADN es mutante.
  - **403 Forbidden**: El ADN no es mutante.

#### `GET /stats`
Devuelve estadísticas de las verificaciones de ADN realizadas hasta el momento, incluyendo el conteo de ADN mutante y no mutante, así como el ratio entre ambos.

## Pruebas

- **Pruebas unitarias y de integración**: Ejecutar `mvn test`.
- **Pruebas de carga**: Utilizar **JMeter** para simular tráfico masivo y verificar el rendimiento del sistema. Pruebas simuladas en documentación


## Documentación
- Documentos adicionales en formato PDF : https://drive.google.com/drive/folders/1vAciHH5qIIvlRWIxSkLNTlTs42XxT-tf?usp=drive_link
