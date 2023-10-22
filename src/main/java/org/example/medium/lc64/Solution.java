package org.example.medium.lc64;

import java.util.ArrayDeque;

class Solution {
    public int minPathSum(int[][] grid) {
        int lr = grid.length;
        int lc = grid[0].length;

        for (int r = 0 ; r < lr ; r++) {
            for (int c = 0; c < lc; c++) {
                if (r == 0 && c == 0) {
                    continue;
                }

                if ((-1 < r - 1) && (-1 < c - 1)) {
                    grid[r][c] =
                            Math.min(grid[r - 1][c] + grid[r][c], grid[r][c - 1] + grid[r][c]);
                }else if ((-1 < c - 1)) {
                    grid[r][c] = grid[r][c - 1] + grid[r][c];
                }else {
                    grid[r][c] = grid[r - 1][c] + grid[r][c];
                }
            }
        }

        return grid[lr - 1][lc - 1];
    }
}