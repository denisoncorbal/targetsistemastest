package com.dgc;

public class Problem5 {
    public static String solveProblem(String arg) {
        String result = "";
        for (int i = arg.length() - 1; i >= 0; i--) {
            result += arg.charAt(i);
        }
        return result;
    }
}
