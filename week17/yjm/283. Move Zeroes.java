public class LeetCode283 {
    /**
     * 283. Move Zeroes
     * https://leetcode.com/problems/move-zeroes/
     *
     * Example:
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     *
     * Note:
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.moveZeroes(new int[]{0,1,0,3,12});  // [1,3,12,0,0]
    }

    static class Solution {
        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
        // Memory Usage: 40.3 MB, less than 20.09% of Java online submissions for Move Zeroes.
        public void moveZeroes(int[] nums) {
            int size = nums.length;

            int baseIdx = 0;
            int checkIdx = -1;
            while (baseIdx < size) {
                if (nums[baseIdx] == 0) {
                    if (checkIdx == -1) { checkIdx = baseIdx; }
                    checkIdx = findNoneZeroIndex(nums, checkIdx + 1);
                    if (checkIdx == -1) {
                        break;
                    }

                    nums[baseIdx] = nums[checkIdx];
                    nums[checkIdx] = 0;
                }
                baseIdx++;
            }
        }

        public int findNoneZeroIndex(int[] n, int startIdx) {
            int ret = -1;
            for (int i = startIdx; i < n.length; i++) {
                if (n[i] != 0) {
                    ret = i;
                    break;
                }
            }
            return ret;
        }
    }
}
