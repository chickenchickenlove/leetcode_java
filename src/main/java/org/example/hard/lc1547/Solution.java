package org.example.hard.lc1547;

import java.util.*;
import java.util.stream.IntStream;


// Leetcode에서는 static 사용하면 안됨. 멀티 쓰레드로 처리하는 거 같아서, 결과가 다르게 나올 수 있음.
class Solution {

    static record Tuple(int start, int end) {
    }


    private Integer cost(int start, int end, Map<Tuple, Integer> memo, int[] cuts) {
        Tuple key = new Tuple(start, end);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (end - start == 1) {
            memo.put(new Tuple(start, end), 0);
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i++) {
            int left = cost(start, i, memo, cuts);
            int right = cost(i, end, memo, cuts);
            min = Math.min(min, left + right + cuts[end] - cuts[start]);
        }
        memo.put(new Tuple(start, end), min);
        return min;
    }


    public int minCost(int n, int[] cuts) {
        int[] newCuts = new int[cuts.length + 2];
        IntStream sorted = Arrays.stream(cuts).sorted();
        int[] ints = sorted.toArray();
        System.arraycopy(ints, 0, newCuts, 1, cuts.length);
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;

        Map<Tuple, Integer> memo = new HashMap<>();

        return cost(0, newCuts.length - 1, memo, newCuts);
    }
}