package com.dgc;

public class Problem1 {
    public static int solveProblem() {
        int INDICE = 13, SOMA = 0, K = 0;

        while (K < INDICE) {
            K += 1;
            SOMA += K;
        }

        return SOMA;
    }
}
