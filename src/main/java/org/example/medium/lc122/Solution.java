package org.example.medium.lc122;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        }
        return solution(n - 1, prices);
    }

    private int solution(int i, int[] prices) {
        if (i == 0) {
            return 0;
        }

        int previousValue = solution(i - 1, prices);
        int diff = prices[i] - prices[i - 1];
        int start_diff = prices[i] - prices[0];
        return Math.max(Math.max(previousValue + diff,
                        previousValue),
                        start_diff);
    }

}