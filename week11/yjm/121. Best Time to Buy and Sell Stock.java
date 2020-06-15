public class LeetCode121 {
    /**
     * 121. Best Time to Buy and Sell Stock
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     *
     * Example 1:
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     *              Not 7-1 = 6, as selling price needs to be larger than buying price.
     *
     * Example 2:
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     * */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int size = prices.length;
            int max = 0;
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (prices[i] > prices[j]) continue;
                    max = Math.max(max, (prices[j] - prices[i]));
                }
            }
            return max;
        }
    }
}
