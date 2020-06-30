class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount+1];
        int answer = findCombi(coins, amount, amounts);
        
        return answer > amount ? -1 : answer;
    }
    
    private int findCombi(int[] coins, int remainder, int[] amounts) {
        
        if(remainder < 0 ) {
            return Integer.MAX_VALUE-1;
        }
        if(remainder == 0) {
            return 0;
        }
        if(amounts[remainder] > 0) {
            return amounts[remainder];
        }
        int min = Integer.MAX_VALUE-1;
        
        for(int i=0; i<coins.length; i++) {
            
            min = Math.min(min, findCombi(coins, remainder-coins[i], amounts)+1);
        }
        return amounts[remainder] = min;
    }
}
