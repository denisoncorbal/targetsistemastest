package com.dgc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Problem3 {
    public static void solveProblem() {
        List<Integer> logic = new ArrayList<>();
        // a = números ímpares
        for (int i = 1; i < 10; i += 2)
            logic.add(i);
        System.out.println("a) " + logic);
        logic.clear();
        // b = potências de 2
        for (int i = 2; i <= 128; i *= 2)
            logic.add(i);
        System.out.println("b) " + logic);
        logic.clear();
        // c = soma dos ímpares
        int soma = 0;
        logic.add(soma);
        for (int i = 1; i < 14; i += 2)
            logic.add(soma += i);
        System.out.println("c) " + logic);
        logic.clear();
        // d = f(ant, count) = ant + 12 + (8 * count)
        int ant = 4;
        logic.add(ant);
        for (int count = 0; count <= 3; count++)
            logic.add(ant = ant + 12 + (8 * count));
        System.out.println("d) " + logic);
        logic.clear();
        // e = fibonacci
        logic.add(0);
        logic.add(1);
        for (int count = 0; count <= 5; count++) {
            logic.add(logic.get((logic.size() - 1)) + logic.get((logic.size() - 2)));
        }
        logic.removeFirst();
        System.out.println("e) " + logic);
        logic.clear();
        // f = números iniciados com a letra 'D'
        logic.add(2);
        for (int i = 0; i < 7; i++) {
            for (int j = logic.getLast() + 1; logic.size() <= i + 1; j++) {
                if (inteiroPorExtensoAteCentenas(j).startsWith("d")) {
                    logic.add(j);
                }
            }
        }
        System.out.println("f) " + logic);
        logic.clear();
    }

    private static String inteiroPorExtensoAteCentenas(int num) {
        int[] casas = getCasasDecimais(num);
        if (casas.length != 3)
            return null;
        int unidade = casas[0], dezena = casas[1], centena = casas[2];
        // casos especiais
        if (centena == 0 && dezena == 0 && unidade == 0)
            return "zero";
        if (centena == 1 && dezena == 0 && unidade == 0)
            return "cem";
        if (dezena == 1) {
            switch (unidade) {
                case 0:
                    return centenaPorExtenso(centena) + "dez";
                case 1:
                    return centenaPorExtenso(centena) + "onze";
                case 2:
                    return centenaPorExtenso(centena) + "doze";
                case 3:
                    return centenaPorExtenso(centena) + "treze";
                case 4:
                    return centenaPorExtenso(centena) + "quatorze";
                case 5:
                    return centenaPorExtenso(centena) + "quinze";
                case 6:
                    return centenaPorExtenso(centena) + "dezesseis";
                case 7:
                    return centenaPorExtenso(centena) + "dezessete";
                case 8:
                    return centenaPorExtenso(centena) + "dezoito";
                case 9:
                    return centenaPorExtenso(centena) + "dezenove";
            }
        }

        // caso padrão
        return centenaPorExtenso(centena) + dezenaPorExtenso(dezena) + unidadePorExtenso(unidade);
    }

    private static int[] getCasasDecimais(int num) {
        int[] result = { 0, 0, 0 };
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                result[0] = num % 10;
                num /= 10;
            } else if (i == 1) {
                result[1] = num % 10;
                num /= 10;
            } else {
                result[2] = num % 10;
                num /= 10;
            }
        }
        return result;
    }

    private static String centenaPorExtenso(int num) {
        Map<Integer, String> centenas = Map.of(
                0, "",
                1, "cento e ",
                2, "duzentos e ",
                3, "trezentos e ",
                4, "quatrocentos e ",
                5, "quinhentos e ",
                6, "seiscentos e ",
                7, "setecentos e ",
                8, "oitocentos e ",
                9, "novecentos e ");
        return centenas.get(num);
    }

    private static String dezenaPorExtenso(int num) {
        Map<Integer, String> dezenas = Map.of(
                0, "",
                1, "dez e ",
                2, "vinte e ",
                3, "trinta e ",
                4, "quarenta e ",
                5, "cinquenta e ",
                6, "sessenta e ",
                7, "setenta e ",
                8, "oitenta e ",
                9, "noventa e ");
        return dezenas.get(num);
    }

    private static String unidadePorExtenso(int num) {
        Map<Integer, String> unidades = Map.of(
                0, "",
                1, "um",
                2, "dois",
                3, "três",
                4, "quatro",
                5, "cinco",
                6, "seis",
                7, "sete",
                8, "oito",
                9, "nove");
        return unidades.get(num);
    }

}
