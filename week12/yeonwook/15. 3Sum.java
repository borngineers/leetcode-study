class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-1; i++) {
            
            if(i>0 && nums[i-1] == nums[i]) continue;
            
            int left = i+1;
            int right = nums.length - 1;
            
            while(left < right) {
                
                int sum = nums[i] + nums[left] + nums[right];
                
                if(sum == 0) {
                    
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    while(nums[right] == nums[right+1] && left < right) right--;
                    while(nums[left] == nums[left-1] && left < right) left++;
                    
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }
}
