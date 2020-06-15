public class LeetCode53 {
    /**
     * 53. Maximum Subarray
     * https://leetcode.com/problems/maximum-subarray/
     *
     * Example:
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArray(new int[]{-2,1}));
        System.out.println(solution.maxSubArray(new int[]{-1,0,-2}));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length < 1) { return 0; }
            int size = nums.length;
            int maxSum = nums[0];

            for (int i = 0; i < size; i++) {
                int sum = nums[i];
                maxSum = Math.max(maxSum, sum);
                for (int j = i + 1; j < size; j++) {
                    sum += nums[j];
                    maxSum = Math.max(maxSum, sum);
                }
            }
            return maxSum;
        }
    }
}
