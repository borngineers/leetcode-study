class Solution {
    public int[] twoSum(int[] nums, int target) {
        int numsCnt = nums.length;
        int i,j = 0;
        int[] result = new int[]{0,0};
        for(i = 0; i < numsCnt; i++){
            for(j = i+1; j < numsCnt; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
    }
}