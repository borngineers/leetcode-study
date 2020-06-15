package practice;

public class Solution3 {
	
	public static void main(String args[]) {
		
		MinCostClimbingStairs c1 = new MinCostClimbingStairs();
		
		int[] costs1 = {10, 15, 20};
		System.out.println(c1.minCostClimbingStairs(costs1));
		
		int[] costs2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(c1.minCostClimbingStairs(costs2));
		
		int[] costs3 = {0,0,0,0};
		System.out.println(c1.minCostClimbingStairs(costs3));
		
		int[] costs4 = {0,1,1,1};
		System.out.println(c1.minCostClimbingStairs(costs4));
		
		int[] costs5 = {1,2,2,2};
		System.out.println(c1.minCostClimbingStairs(costs5));
		
		int[] costs6 = {1,2,2,0}; 
		System.out.println(c1.minCostClimbingStairs(costs6));
		
	}
}

class MinCostClimbingStairs {
	
	
    public int minCostClimbingStairs(int[] cost) {
        
    	int len = cost.length;
    	
    	if(len==0 || len==1) {
    		return 0;
    	}
    	
    	int preMinCost1 = 0;
    	int preMinCost2 = 0;
    	int minCost = 0;
    	
    	for(int i=1;i<len;i++) {
    		
    		minCost = Math.min(preMinCost1+cost[i-1], preMinCost2+cost[i]);
    		preMinCost1 = preMinCost2;
    		preMinCost2 = minCost;
    	}
    	
    	return minCost;
    }
    
    
}