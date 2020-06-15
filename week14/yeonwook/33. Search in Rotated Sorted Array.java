class Solution {
    public int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            
            int mid = (left + right) >> 1;            
            
            if(nums[mid]==target) return mid;
            
            if(target < nums[mid]) {
                
                if(nums[mid] > nums[right] && target <= nums[right]) {
                    left = mid +1;
                    continue;
                }
                
                right = mid -1;
                
            } else {
                
                if(nums[mid] < nums[left] && target >= nums[left]) {
                    right = mid -1;
                    continue;
                }
                
                left = mid + 1;
            }
        }
        
        return -1;
    }
}
