package com.dgc;

import java.util.Scanner;

public class App {
    private static final Scanner scan = new Scanner(System.in);
    private static final String STRING_A_SER_INVERTIDA = "Teste aqui sua string";

    public static void main(String[] args) {
        System.out.println("Resposta ao problema de número 1");
        System.out.println("Ao final do processamento o valor da variável soma será: " + Problem1.solveProblem());
        System.out.println("");
        System.out.println("Resposta ao problema de número 2");
        System.out.println("Insira o número para conferir se está ou não na sequência Fibonacci");
        int checkFib = scan.nextInt();
        System.out.println(Problem2.solveProblem(checkFib) ? "O número está na sequência Fibonacci"
                : "O número não está na sequência Fibonacci");
        System.out.println("");
        System.out.println("Resposta ao problema de número 3");
        Problem3.solveProblem();
        System.out.println("");
        System.out.println("Resposta ao problema de número 4");
        Problem4.solveProblem();
        System.out.println("");
        System.out.println("Resposta ao problema de número 5");
        System.out.println("String normal: " + STRING_A_SER_INVERTIDA);
        System.out.println("String invertida: " + Problem5.solveProblem(STRING_A_SER_INVERTIDA));
        System.out.println("");
        System.exit(0);
    }
}
