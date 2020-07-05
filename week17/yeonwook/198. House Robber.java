class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int a = nums[0];
        int b = nums[1];
        int answer = 0;
        
        for(int i=2; i<nums.length; i++) {
            
            answer = Math.max(a+nums[i], b);
            a = b;
            b  = answer;
        }
        
        return answer;
    }
}

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
