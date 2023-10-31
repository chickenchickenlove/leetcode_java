package org.example.hard.lc4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final List<Integer> ints = new ArrayList<>();
        for (int n1 : nums1) {
            ints.add(n1);
        }

        for (int n2 : nums2) {
            ints.add(n2);
        }

        int len = ints.size();

        List<Integer> integerList = ints.stream().sorted().toList();
        int mid = (len / 2) - 1;

        if (len % 2 == 1) {
            return integerList.get(mid + 1);
        } else {
            return ((float) (integerList.get(mid) + (float) integerList.get(mid + 1)) / 2);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{3, 4};
        new Solution().findMedianSortedArrays(a, b);

    }
}