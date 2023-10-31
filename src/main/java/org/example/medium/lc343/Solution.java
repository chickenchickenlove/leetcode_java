package org.example.medium.lc343;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];

        // init
        for (int i = 0; i < Math.min(2, n) + 1; i++) {
            dp[i] = 1;
        }

        for (int i = 3; i < n + 1; i++) {
            for (int diff = 1; diff < i; diff++) {
                int j = i - diff;
                dp[i] = Stream.of(j * diff, dp[j] * diff, dp[j] * dp[diff], j * dp[diff], dp[i])
                        .max(Comparator.comparingInt(value -> value)).get();
            }
        }
        return dp[n];
    }
}

