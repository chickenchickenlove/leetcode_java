package org.example.medium.lc198;

import java.util.Comparator;
import java.util.stream.Stream;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        dp[0][1] = nums[0];
        int ret = nums[0];
        if (n > 1){
            dp[1][0] = nums[0];
            dp[1][1] = nums[1];
            ret = Math.max(ret, nums[1]);
        }

        for (int day = 2; day < n; day++) {
            dp[day][0] = Math.max(dp[day - 1][1], dp[day - 1][0]);
            dp[day][1] = dp[day - 1][0] + nums[day];

            ret = Stream.of(ret, dp[day][0], dp[day][1])
                    .max(Integer::compareTo).get();
        }

        return ret;
    }
}