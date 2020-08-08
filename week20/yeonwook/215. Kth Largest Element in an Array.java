class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int target = nums.length-k;
        
        return nums[target];
        
    }
}
