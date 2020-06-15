package solved.p121;

class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buyPrice = Math.min(buyPrice, prices[i]);
            answer = Math.max(answer, prices[i] - buyPrice);
        }
        return answer;
    }
}

// class Solution {
//     public int maxProfit(int[] prices) {
//         int answer = 0;
//         for (int i = 0; i < prices.length; i++) {
//             for (int j = i + 1; j < prices.length; j++) {
//                 answer = Math.max(answer, prices[j] - prices[i]);
//             }
//         }
//         return answer;
//     }
// }
