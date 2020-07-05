class Solution {
    public void moveZeroes(int[] nums) {    
        final Stack<Integer> zeroIndexes = new Stack<>();
        for(int index = 0; index < nums.length; index++) {
            if(nums[index] != 0){
                continue;
            }
            
            zeroIndexes.add(index);
        }
        
        int moveCount = 0;
        final int lastIndex = nums.length - 1; 
        
        // zero index 를 스택에 역방향으로 쌓음
        while(!zeroIndexes.isEmpty()){
            final int zeroIndex = zeroIndexes.pop();
            final int lastNumberIndex = lastIndex - moveCount;
            
            for(int index = zeroIndex + 1; index <= lastNumberIndex; index++) {
                nums[index - 1] = nums[index];
            }
            
            nums[lastNumberIndex] = 0;
            moveCount++;
        }
    }
}
