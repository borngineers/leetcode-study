import java.util.Stack;

class Solution {
    
    public int[] dailyTemperatures(int[] T) {
        // 32ms
        final int length = T.length;
        final int[] ret = new int[length];
        final Stack<Integer> stack = new Stack<>();   
        
        for(int index = length - 1; index >= 0; index--) {
            
            while(!stack.isEmpty() && T[index] >= T[stack.peek()]) {
                stack.pop();
            }
            
            ret[index] = stack.isEmpty() ? 0 : stack.peek() - index;
            stack.push(index);
        }
        
        return ret;
    }
    
    public int[] dailyTemperatures2(int[] T) {
        // 현재 날로부터 따뜻해지는 날이 얼마나 남아있는지 여부
        // 910ms
        final int length = T.length;
        final int[] ret = new int[length];
        
        for(int index = 0; index < length; index++) {
            int tValue = T[index];
            int count = 0;
            boolean isFind = false;
            
            for(int subIndex = index + 1; subIndex < length; subIndex++) {
                if(tValue < T[subIndex]) {
                    count++;
                    isFind = true;
                    break;
                }
                count++;
            } 
            
            if(isFind) {
                ret[index] = count;   
            } else {
                ret[index] = 0;
            }
        }
        
        return ret;
    }
}
