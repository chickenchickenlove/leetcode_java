package org.example.medium.lc256;

import java.util.Arrays;

class Solution {
    public int minCost(int[][] costs) {
        final int house = costs.length;
        final int color = costs[0].length;
        final int[][] dp = new int[house][color];

        for (int i = 0; i < color; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < house; i++) {
            for (int j = 0; j < color; j++) {
                int previousMin = Integer.MAX_VALUE;
                for (int k = 0; k < color; k++) {
                    if (j == k ) continue;
                    previousMin = Math.min(previousMin, dp[i - 1][k]);
                }
                dp[i][j] = previousMin + costs[i][j];
            }
        }

        return Arrays.stream(dp[house - 1]).min().getAsInt();
    }
}