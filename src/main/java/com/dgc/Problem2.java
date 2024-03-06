package com.dgc;

public class Problem2 {
    public static boolean solveProblem(int num) {
        if (num == 0 || num == 1)
            return true;
        return isFib(1, 1, num);
    }

    private static boolean isFib(int prev1, int prev2, int num) {
        int nextFib = prev1 + prev2;
        if (num == nextFib)
            return true;
        if (num < nextFib)
            return false;
        return isFib(prev2, nextFib, num);
    }
}
