class Solution {
    public int missingNumber(int[] nums) {
        
        int[] check = new int[nums.length+1];
        
        for(int a : nums) {
            check[a]++;
        }
        
        for(int i=0; i<nums.length+1; i++) {
            if(check[i] == 0) return i;
        }
        
        return 0;
    }
}
