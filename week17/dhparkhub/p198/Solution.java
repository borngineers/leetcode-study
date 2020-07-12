package p198;

import java.util.Arrays;

class Solution {
    private int[] nums;
    private int[] cache;

    public int rob(int[] nums) {
        this.nums = nums;
        this.cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return getMaxMoney(nums.length - 1);
    }

    private int getMaxMoney(int index) {
        if (index < 0) return 0;
        if (cache[index] != -1) return cache[index];
        int case1 = nums[index] + getMaxMoney(index - 2);
        int case2 = getMaxMoney(index - 1);
        return cache[index] = Math.max(case1, case2);
    }
}