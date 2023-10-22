package org.example.medium.lc63;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {


    private static final List<Coordinator> MOVE = List.of(
            new Coordinator(1, 0),
            new Coordinator(0, 1));

    public static record Coordinator(int r, int c){};

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int lr = obstacleGrid.length;
        int lc = obstacleGrid[0].length;
        int[][] dp = new int[lr][lc];
        int[][] visit = new int[lr][lc];

        // Corner Case
        if ((obstacleGrid[lr - 1][lc - 1] == 1) ||
                obstacleGrid[0][0] == 1) {
            return 0;
        }

        // set init value.
        dp[0][0] = 1;
        Deque<Coordinator> q = new ArrayDeque<>(List.of(new Coordinator(0, 0)));

        while (!q.isEmpty()) {
            Coordinator now = q.pollFirst();
            if (visit[now.r][now.c] != 0)
                continue;

            visit[now.r][now.c] = 1;

            for (Coordinator move : MOVE) {
                int nextR = now.r + move.r;
                int nextC = now.c + move.c;

                if ((-1 < nextR) &&
                        (nextR < lr) &&
                        (-1 < nextC) &&
                        (nextC < lc) && (obstacleGrid[nextR][nextC] != 1)) {
                    dp[nextR][nextC] += dp[now.r][now.c];

                    q.add(new Coordinator(nextR, nextC));
                }
            }
        }
        return dp[lr-1][lc-1];
    }
}