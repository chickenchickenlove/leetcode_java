package org.example.medium.lc63;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {
        int[][] ints = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        Solution solution = new Solution();
        solution.uniquePathsWithObstacles(ints);
    }

}