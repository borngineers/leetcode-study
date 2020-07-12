package p283;

class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
                continue;
            }
            if (zeroCnt == 0) {
                continue;
            }
            swap(nums, i, i - zeroCnt);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}