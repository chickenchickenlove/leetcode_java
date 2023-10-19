package org.example.medium.lc33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        Solution solution = new Solution();
        int result = solution.search(nums, target);

        System.out.println(result);


    }

}