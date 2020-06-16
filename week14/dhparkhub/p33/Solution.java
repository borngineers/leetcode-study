package published.p33;

import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        // ascending case
        if (nums[0] < nums[nums.length - 1]) {
            int index = Arrays.binarySearch(nums, 0, nums.length, target);// O(logN)
            return index >= 0 ? index : -1;
        }

        // find minimum number's index
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
                continue;
            }
            r = m;
        }// O(logN)

        int index = 0;
        if (target >= nums[0]) {
            index = Arrays.binarySearch(nums, 0, l, target);// O(logN)
        } else {
            index = Arrays.binarySearch(nums, l, nums.length, target);// O(logN)
        }

        return index >= 0 ? index : -1;
    }
}
