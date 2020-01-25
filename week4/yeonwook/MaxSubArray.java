package practice;

public class Solution2 {
	
	public static void main(String args[]) {
		
		//int[] testCase1 = {-2,1,-3,4,-1,2,1,-5,4};
		//int[] testCase1 = {-2,-1};
		//int[] testCase1 = {1};
		int[] testCase1 = {-2,3,1,3};
		
		System.out.println("result : " + maxSubArray(testCase1));
	}
	
    public static int maxSubArray(int[] nums) {
    	
    	int len = nums.length;
    	if(len==0) {
    		return 0;
    	}
    	
    	int start =0;
    	int end = 0;

    	int maxSum = nums[start];    	
    	int tempSum = (nums[start]<0) ? 0 : nums[start];
    	end++;
    	
    	while(end!=len) {
    		
    		if(tempSum + nums[end]>0) {
    			tempSum += nums[end];
    			
    			end++;
    		} else {
    			tempSum = nums[end];
    			
    			end++;
    			start = end;
    		}
    		
    		if(maxSum<tempSum) {
    			maxSum = tempSum;
    		} 
    		
    		if(tempSum<0) {
    			tempSum=0;
    		}
    	}
     
    	return maxSum;
    }
}
