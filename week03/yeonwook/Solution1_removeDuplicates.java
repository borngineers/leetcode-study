package practice;

public class Solution1 {
	
	public static void main(String args[]) {
	
		int[] intput1 = {1,1,2,2};
		
		System.out.println(removeDuplicates(intput1));
		
		int[] intput2 = {0,0,1,1,1,2,2,3,3,4};
		
		System.out.println(removeDuplicates(intput2));
		
		
	}
	
	public static int removeDuplicates(int[] nums) {
	        
		if(nums.length==1 || nums.length==0) {
			return nums.length;
		}
		
		int tempIndex = 0;
		for(int i=1; i<nums.length; i++) {
			
			if(nums[tempIndex] != nums[i]) {
				nums[++tempIndex] = nums[i];
			} 
			
		}
		
		return tempIndex+1;
	}
    
}
