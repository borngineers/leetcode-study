package practice;

import practice.MinCostClimbingStairs;

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
    	
    	int minCost = 0;
    	int index = -1;
    	
    	while(index < len-2) {
    		
    		if(index==len-4) {
    			minCost += Math.min(cost[index+2], cost[index+1]+cost[index+3]);
    			break;
    		} 
    		
    		if(cost[index+1]<cost[index+2]) {
    			minCost += cost[index+1];
    			index += 1;
    		} else {
    			minCost += cost[index+2];
    			index += 2;
    		}
    		
    		System.out.println("value[index] : "+cost[index]+"["+index+"]");
    		
    	}
    	
    	return minCost;
    }
}