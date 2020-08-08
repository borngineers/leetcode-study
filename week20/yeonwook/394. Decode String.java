class Solution {
    public String decodeString(String s) {
        
        int len = s.length();
        if(len ==0 ) return "";
        
        Stack<String> st = new Stack<>();
        StringBuilder answer = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        double num = 0;
        
        for(int i=len-1; i>=0; i--) {
            
            //숫자이면 숫자일때까지 계속 계산 후 temp를 숫자만큼 반복해서 쌓아준다
            if(Character.isDigit(s.charAt(i))) {
                
                num = s.charAt(i)-'0';
                int k = 1;
                while(i>0 && Character.isDigit(s.charAt(i-1))) {
                    num = num + (s.charAt(--i)-'0')*Math.pow(10,k);
                    k++;
                    
                }
                
                for(int j=0; j<num; j++) {
                    st.push(temp.toString());
                }
              
                temp.setLength(0);  
                continue;
            
            } 
            //문자이면 스택에 쌓아주다가 '['를 만나면 temp에 저장
            
            if(s.charAt(i) == '[') {
                while(!st.peek().equals("]")) {
                    temp.append(st.pop());
                }
                st.pop();
            } else {
                st.push(String.valueOf(s.charAt(i)));
            }
            
            
        }
        
        while(!st.isEmpty()) {
            answer.append(st.pop());
        }
        
        return answer.toString();
    }
}
