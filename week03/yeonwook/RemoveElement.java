package test;

import test.Solution99;

public class Practice {

	
	
	public static void main(String args[]) {
		
		
		Solution99 tt = new Solution99();
		
		int[] arr = new int[] {2};
		
		System.out.println(tt.removeElement(arr, 3));
		
		for(int a:  arr) {
			System.out.print(a + ", ");
		}
		
	}
}


class Solution99 {
	
    public int removeElement(int[] nums, int val) {
    	
    	int tempIndex = 0;
    	
    	for(int i=0; i<nums.length; i++) {
    		if(nums[i]!=val) {
    			nums[tempIndex] = nums[i];
    			tempIndex++;
    		} 
    	}
    	
    	return tempIndex;
    }
}