class Solution {
    public int maxProfit(int[] prices) {
        
        int answer = 0;
        int len = prices.length;        
        int minProfit = Integer.MAX_VALUE;
        
        for(int i=0; i<len; i++) {
            if(prices[i] < minProfit) {
                minProfit = prices[i];
            } else if(prices[i] - minProfit > answer) {
                answer = prices[i] - minProfit;
            }
        }
        
        return answer;
    }
    
    public int maxProfit2(int[] prices) {
        
        int answer = 0;
        int len = prices.length;        
        
        for(int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                
                if(prices[j]-prices[i] > answer) {
                    answer = prices[j]-prices[i];
                }
            }
        }
        
        return answer;
    }    
}
