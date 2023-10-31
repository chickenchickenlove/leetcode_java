package org.example.hard.lc123;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] left = new int[n];
        int minimumPrice = Integer.MAX_VALUE; int maxValue = 0;
        for (int i = 0; i < n; i++) {
            int nowPrice = prices[i];
            minimumPrice = Math.min(nowPrice, minimumPrice);
            maxValue = Math.max(maxValue, nowPrice - minimumPrice);
            left[i] = maxValue;
        }

        int[] right = new int[n];
        int maxRight = 0; int maxValueRight = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, prices[i]);
            maxValue = Math.max(maxValueRight, maxRight - prices[i]);
            right[i] = maxValue;
        }

        int result = Math.max(left[0], left[n - 1]);
        result = Math.max(result, right[0]);
        result = Math.max(result, right[n - 1]);


        for (int i = 0; i < n-1; i++) {
            result = Math.max(result, left[i] + right[i + 1]);
        }

        return result;
    }
}