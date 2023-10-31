package org.example.easy.lc121;

class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int mv = Integer.MAX_VALUE;

        for (int p : prices) {
            mv = Math.min(p, mv);
            result = Math.max(p - mv, result);
        }
        return result;
    }
}