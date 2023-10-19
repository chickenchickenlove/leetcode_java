package org.example.medium.lc454;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class Solution {

    public Solution() {

    }

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