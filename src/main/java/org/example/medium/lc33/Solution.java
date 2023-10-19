package org.example.medium.lc33;

class Solution {

    private int getFunc(int n, int l) {
        return n >= l ? n - l : n;
    }

    private int getEndPosition(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        int maxValue = Integer.max(nums[l], nums[r]);
        int maxPosition = nums[l] < nums[r] ? r : l;

        while (l <= r ) {
            int m = (l + r) / 2;
            if (nums[l] > Integer.max(nums[m], nums[r])) {
                if (nums[l] > maxValue) {
                    maxValue = nums[l];
                    maxPosition = l;
                }
                r = m - 1;
            } else {
                if ((nums[m] > nums[r]) && nums[m] > maxValue) {
                    maxValue = nums[m];
                    maxPosition = m;
                } else if ((nums[m] < nums[r]) && (nums[r] > maxValue)) {
                    maxValue = nums[r];
                    maxPosition = r;
                }
                l = m + 1;
            }
        }
        return maxPosition;
    }

    public int search(int[] nums, int target) {
        int endPosition = getEndPosition(nums);
        int l = endPosition + 1;
        int r = endPosition + nums.length;

        while (l <= r) {
            int m = (l + r) / 2;
            int ml = getFunc(m, nums.length);
            if (nums[ml] == target) {
                return ml;
            } else if (nums[ml] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}