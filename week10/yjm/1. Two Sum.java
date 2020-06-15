import java.util.OptionalInt;
import java.util.stream.IntStream;

public class LeetCode1 {
    /**
     * 1. Two Sum
     * https://leetcode.com/problems/two-sum/
     *
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                int temp = i;
                OptionalInt a = IntStream.range(i+1, nums.length)
                        .filter(j -> nums[temp] + nums[j] == target)
                        .findFirst();

                if (a.isPresent()) {
                    return new int[]{i, a.getAsInt()};
                }
            }

            return nums;
        }
    }
}
