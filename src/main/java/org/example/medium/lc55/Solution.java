package org.example.medium.lc55;

class Solution {

    // Greedy
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int carry = nums[0];
        if (n == 1) {
            return true;
        }

        for (int i = 1; i < n; i++) {
            if (carry <= 0) {
                return false;
            }
            carry = Math.max(carry - 1, nums[i]);
        }
        return true;
    }





    // Btm -> Top
    /*
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((nums[j] + j) >= i && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
     */
}