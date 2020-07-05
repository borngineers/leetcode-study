class Solution {
    public void moveZeroes(int[] nums) {
        
        Queue<Integer> qu = new LinkedList<>();
        int zeroCnt = 0;
        
        for(int a : nums) {
            if(a == 0) {
                zeroCnt++;
            } else {
                qu.add(a);                
            }
        }
        
        int size = qu.size();
        
        for(int i=0; i<nums.length; i++) {
            if(i < size) {
                nums[i] = qu.poll();
            } else {
                nums[i] = 0;
            }
        }
        
    }
}
