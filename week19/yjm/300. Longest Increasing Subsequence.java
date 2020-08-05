class Solution {
    // case error
    public int lengthOfLIS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prevNum = Integer.MAX_VALUE;

        for (int i = nums.length - 1; i > -1 ; i--) {

            if (nums[i] < prevNum) {
                if (map.containsKey(prevNum)) {
                    map.put(nums[i], map.get(prevNum) + 1);
                } else {
                    map.put(nums[i], 1);
                }
                prevNum = nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }

        int maxVal = 0;
        for (int key : map.keySet()) {
            maxVal = Math.max(maxVal, map.get(key));
        }

        return maxVal;
    }
}
