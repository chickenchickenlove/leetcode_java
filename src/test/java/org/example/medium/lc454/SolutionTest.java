package org.example.medium.lc454;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {

        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{-2, -1};
        int[] nums3 = new int[]{-1, -2};
        int[] nums4 = new int[]{0, 2};


        Solution solution = new Solution();
        int result = solution.fourSumCount(nums1, nums2, nums3, nums4);

        System.out.println(result == 4);
    }
}