public class LeetCode268 {
    /**
     * 268. Missing Number
     * https://leetcode.com/problems/missing-number/
     *
     * Example 1:
     * Input: [3,0,1]
     * Output: 2
     *
     * Example 2:
     * Input: [9,6,4,2,3,5,7,0,1]
     * Output: 8
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.missingNumber(new int[]{3,0,1});  // 2
        System.out.println(result);

        result = solution.missingNumber(new int[]{9,6,4,2,3,5,7,0,1});  // 8
        System.out.println(result);

        result = solution.missingNumber(new int[]{0});  // 1
        System.out.println(result);
    }

    static class Solution {
        // Runtime: 1 ms, faster than 52.07% of Java online submissions for Missing Number.
        // Memory Usage: 48.6 MB, less than 7.14% of Java online submissions for Missing Number.
        public int missingNumber(int[] nums) {
            int size = nums.length;
            boolean[] checkNums = new boolean[size+1];

            for (int i = 0; i < size; i++) {
                checkNums[nums[i]] = true;
            }

            for (int i = 0; i < checkNums.length; i++) {
                if (checkNums[i] == false) {
                    return i;
                }
            }
            return 0;
        }
    }
}
