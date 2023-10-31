package org.example.medium.lc15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    private boolean isEnd(int left, int mid, int right) {
        return mid <= left || right <= mid;

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int start = 1;
        int end = nums.length;
        int[] n = Arrays.stream(nums).sorted().toArray();

        for (int m = start; m < end; m++) {
            int left = 0;
            int right = n.length-1;
            while (!isEnd(left, m, right)) {
                int sum3 = n[left] + n[m] + n[right];

                if (sum3 == 0) {
                    result.add(List.of(n[left], n[m], n[right]));
                    left += 1;
                }
                if (sum3 > 0)
                    right -= 1;
                if (sum3 < 0)
                    left += 1;
            }
        }

        return result.stream().toList();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Solution().threeSum(nums);
        System.out.println(lists);
    }
}