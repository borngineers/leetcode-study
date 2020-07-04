class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 0) return 0;
        
        int odd = 0;
        int even = 0;
        
        for(int i=0; i<nums.length; i++) {
            
            if(i%2 == 1) {
                odd = Math.max(odd + nums[i], even);
            } else {
                even = Math.max(even + nums[i], odd);
            }
        }
        
        return Math.max(odd, even);
    }
}
