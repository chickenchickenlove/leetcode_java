package org.example.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lc454 {





    static class Solution {

        private Map<Integer, Integer> computeMap(int[] n1, int[] n2) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : n1) {
                for (int j : n2 ){
                    int tempSum = i + j;
                    int computedValue =
                            map.containsKey(tempSum) ?
                            map.get(tempSum) + 1 : 1;
                    map.put(tempSum, computedValue);
                }
            }
            return map;
        }

        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> map1 = computeMap(nums1, nums2);
            Map<Integer, Integer> map2 = computeMap(nums3, nums4);

            Optional<Integer> reduce = map1.entrySet().stream()
                    .map(e -> map2.getOrDefault(-e.getKey(), 0) * e.getValue())
                    .reduce(Integer::sum);

            return reduce.get();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{-2, -1};
        int[] nums3 = new int[]{-1, -2};
        int[] nums4 = new int[]{0, 2};

        int i = solution.fourSumCount(nums1, nums2, nums3, nums4);

    }
}
