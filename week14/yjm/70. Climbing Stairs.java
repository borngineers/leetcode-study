import java.util.HashMap;

public class LeetCode70 {
    /**
     * 70. Climbing Stairs
     * https://leetcode.com/problems/climbing-stairs/
     *
     * Example 1:
     * Input: 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     *
     * Example 2:
     * Input: 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.climbStairs(5);
        System.out.println(result);

        result = solution.climbStairs(10);
        System.out.println(result);

        result = solution.climbStairs(20);
        System.out.println(result);
    }

    static class Solution {
        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
        // Memory Usage: 36.3 MB, less than 5.26% of Java online submissions for Climbing Stairs.

        public int climbStairs(int n) {
            HashMap<Integer, Integer> cache = new HashMap<>();
            return calc(cache, n);
        }

        public int calc(HashMap<Integer, Integer> cache, int n) {
            if (n < 2) { return 1; }
            if (n < 3) { return n; }
            if (cache.containsKey(n)) { return cache.get(n); }
            int calc = calc(cache, n-2) + calc(cache, n-1);
            cache.put(n, calc);
            return calc;
        }
    }

}
