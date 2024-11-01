package com.example.mutantapi.service;

import com.example.mutantapi.business.services.HumanService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HumanServiceTest {
    //---------------------MATRICES 4X4-------------------------
    @Test
public void testMutantHorizontalSequences() {
    String[] dna = {
        "AAAA",  // Secuencia mutante horizontal
        "CCCC",  // Secuencia mutante horizontal
        "TTGT",
        "GTAC"
    };
    assertTrue(HumanService.isMutant(dna)); //
}
@Test
public void testMutantVerticalSequences() {
    String[] dna = {
        "ATGC",
        "ATGC",
        "ATGC",
        "ATGC"
    };
     assertTrue(HumanService.isMutant(dna));
}
@Test
public void testMutantDiagonalSequences() {
    String[] dna = {
            "ATGG",
            "CAGC",
            "TGAT",
            "GTAA"  // Secuencia mutante diagonal
    };
  assertTrue(HumanService.isMutant(dna));
}
@Test
public void testNonMutantNoSequences() {
    String[] dna = {
        "ATGC",
        "CAGT",
        "TGAC",
        "CATA"
    };
    assertFalse(HumanService.isMutant(dna));
}
// ------------------OTRAS MARTRICES-------------------------
    @Test
public void testnoTmutanttwosequencesofthree() {
    String[] dna = {
        "ATGCAA",  // Secuencia de tres 'A' al final
        "CAGGTT",
        "TGAATG",
        "AAGGGA",  // Secuencia de tres 'G' en el centro
        "CGTATA",
        "TCCGAT"
    };
    assertFalse(HumanService.isMutant(dna));
}
@Test
public void test_is_not_mutant_with_only_one_vertical_five_letter_sequence() {
    String[] dna = {
        "ATATAT",
        "ACGCGC",
        "ATATAT",
        "ACGCGC",
        "ATATAT",
        "TGGGCC"
    };
    assertFalse(HumanService.isMutant(dna));
}




@Test
public void testLargeMutantMatrix() {
    String[] dna = {
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"
    };
   assertTrue(HumanService.isMutant(dna));
}
@Test
public void AnotherMutantMatrix() {
    String[] dna = {
            "ATGCGA",
            "CTGTAC",
            "TTTAGT",
            "TGACAG",
            "CCCCTA",
            "TCACTG"
    };
   assertTrue(HumanService.isMutant(dna));
}
  @Test
    public void test1() {
        String[] dna = {
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "CCGACCAGT",
                "GGCACTCCA",
                "AGGACACTA",
                "CAAAGGCAT",
                "GCAGTCCCC"
        };
        assertTrue(HumanService.isMutant(dna));
    }

    @Test
    public void test2() {
        String[] dna = {
                "TGAC",
                "ATCC",
                "TAAG",
                "GGTC"
        };
        assertFalse(HumanService.isMutant(dna));
    }

    @Test
    public void test3() {
        String[] dna = {
                "TCGGGTGAT",
                "TGATCCTTT",
                "TACGAGTGA",
                "AAATGTACG",
                "ACGAGTGCT",
                "AGACACATG",
                "GAATTCCAA",
                "ACTACGACC",
                "TGAGTATCC"
        };
        assertTrue(HumanService.isMutant(dna));
    }

    @Test
    public void test4() {
        String[] dna = {
                "AAAA",
                "AAAA",
                "AAAA",
                "AAAA"
        };
        assertTrue(HumanService.isMutant(dna));
    }

    @Test
    public void test5() {
        String[] dna = {
                "TGAC",
                "AGCC",
                "TGAC",
                "GGTC"
        };
        assertTrue(HumanService.isMutant(dna));
    }

    @Test
    public void test6() {
        String[] dna = {
                "AAAT",
                "AACC",
                "AAAC",
                "CGGG"
        };
        assertFalse(HumanService.isMutant(dna));
    }
}


