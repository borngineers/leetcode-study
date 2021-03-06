class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int[] answer = new int[T.length];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<T.length; i++) {
            
            while(!st.isEmpty() && T[i] > T[st.peek()]) {
                int a = st.pop();
                answer[a] = i-a;
            }            
            st.push(i);
        }
        return answer;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int[] answer = new int[T.length];
        
        for(int i=0; i<T.length; i++) {
            for(int j=i; j<T.length; j++) {
                if(T[i]<T[j]) {
                    answer[i] = j-i;
                    break;
                }
            }
        }
        
        return answer;
    }
}
