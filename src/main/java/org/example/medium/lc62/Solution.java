package org.example.medium.lc62;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

class Solution {

    private final static List<Coordinator> MOVES = List.of(new Coordinator(1, 0),
            new Coordinator(0, 1));

    private List<List<Integer>> getList(int m, int n) {
        List<List<Integer>> d = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                t.add(0);
            }
            d.add(t);
        }
        return d;
    }

    public static record Coordinator(int r, int c){};

    public int uniquePaths(int m, int n) {

        List<List<Integer>> dp = getList(m, n);
        List<List<Integer>> visit = getList(m, n);

        Deque<Coordinator> q = new ArrayDeque<>();
        q.add(new Coordinator(0, 0));
        dp.get(0).set(0, 1);

        while (!q.isEmpty()) {
            Coordinator now = q.pollFirst();
            Integer v = visit.get(now.r).get(now.c);

            if (v != 0) {
                continue;
            }
            visit.get(now.r).set(now.c, 1);

            for (Coordinator move : MOVES) {
                int nextR = now.r + move.r();
                int nextC = now.c + move.c();

                if ((-1 < nextR) && (nextR < m) && (-1 < nextC) && (nextC < n)) {
                    int vnext = dp.get(nextR).get(nextC);
                    int vnow = dp.get(now.r).get(now.c);
                    int vnextUpdated = vnext + vnow;
                    dp.get(nextR).set(nextC, vnextUpdated);
                    q.add(new Coordinator(nextR, nextC));
                }
            }
        }

        return dp.get(m - 1).get(n - 1);
    }
}

