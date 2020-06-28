class Solution {
    
    // [2, 3, 5], 16
    // [1, 2, 5], 16
    
    public int coinChange(int[] coins, int amount) {
     Arrays.sort(coins);
        final int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        // 기저사례 : 0원을 만들기 위한 최소 가지수 0;
        dp[0] = 0;

        for(int i = 0; i <= amount; i++){
            for (int coin : coins) {
                if (i >= coin) {
                    // +1 은 코인을 하나 사용했다는 의미.
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                } else {
                    // i < coins[j];
                    break;
                }
            }
        }
        
        // dp 
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
