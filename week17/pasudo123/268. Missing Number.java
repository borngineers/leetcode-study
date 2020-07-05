class Solution {
    public int missingNumber(int[] nums) {
        
        final int n = nums.length;
        int sum = n * (n + 1) / 2;
        
        for(int num : nums) {
            sum -= num;
        }
        
        return sum;
    }
    
    public int missingNumber2(int[] nums) {
        final Map<Integer, Object> space = new HashMap<>();
        for(int i = 0; i <= nums.length; i++){
            space.put(i, new Object());
        }
        
        for(int num : nums) {
            space.remove(num);
        }
        
        return space.keySet().iterator().next();
    }
}
