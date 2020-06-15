public class TwoSum {

	public static void main(String args[]) {
		
		int[] nums = {2, 7, 11, 15};
		int[] result = twoSum(nums, 9);
		System.out.println(result);
	}
	
	
    public static int[] twoSum(int[] nums, int target) {
        
        int[] resultSets = new int[2];
        
        for(int i=0; i<nums.length; i++) {
            
            for(int j=0; j<nums.length; j++) {
                if(i!=j && nums[i]+nums[j]==target) {
                    resultSets[0] = i;
                    resultSets[1] = j;
                    
                    break;
                }
            }
        }
        
        return resultSets;
    }
}