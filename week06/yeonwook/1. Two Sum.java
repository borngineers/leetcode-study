class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] answer = new int[2];
        Map<Integer, Integer> checkMap = new HashMap<Integer, Integer>();
        
        int len = nums.length;
        
        for(int i=0; i<len; i++) {
            checkMap.put(target - nums[i], i);
        }
        for(int i=0; i<len; i++) {
            if( checkMap.containsKey(nums[i]) && i != checkMap.get(nums[i])) {
                answer[0] = i;
                answer[1] = checkMap.get(nums[i]);
            }
        }
               
        return answer;
    }
}