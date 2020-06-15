public class TwoSum {

	public static void main(String args[]) {
		
		int[] nums = {2, 7, 11, 15};
		int[] result = twoSum(nums, 9);
		System.out.println(result);
	}
	
	
    public int[] twoSum(int[] numbers, int target) {
        
        int[] resultSets = new int[2];
        
        for(int i=0; i<numbers.length; i++) {
            
            for(int j=i+1; j<numbers.length; j++) {
                if(numbers[i]+numbers[j]==target) {
                    resultSets[0] = i+1;
                    resultSets[1] = j+1;
                    
                    break;
                }
            }
        }
        
        return resultSets;
    }
}