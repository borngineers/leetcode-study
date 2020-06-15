class Solution {
    public int maxSubArray(int[] nums) {
        
        int len = nums.length;
        if(len == 0) {
            return 0;
        }
        if(len == 1) {
            return nums[0];
        }
        
        int answer = Integer.MIN_VALUE;
        int temp = 0;
        
        for(int i=0; i<len; i++) {
            
            temp += nums[i];
            
            if(temp > answer) {
                answer = temp;
            }
            
            if(temp < 0) {
                temp = 0;
            }
        }
        
        return answer;
    }
}
