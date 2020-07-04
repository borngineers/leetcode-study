class Solution {
    public String countAndSay(int n) {
        
        if(n == 0) return "";
        if(n == 1) return "1";
        
        StringBuilder param = new StringBuilder();
        param.append("1");
        StringBuilder answer = null;
        
        for(int i=1; i<n; i++) {
            answer = compute(param);
            
            param.setLength(0);
            param = answer;
        }
        
        return answer.toString();
    }
    
    public StringBuilder compute(StringBuilder sb) {
        
        StringBuilder answer = new StringBuilder();
        
        char[] target = sb.toString().toCharArray(); 
        
        char pre = target[0];
        int count = 1;
        
        for(int i=1; i<=target.length; i++) {
            
            if(i==target.length) {
                answer.append(count);
                answer.append(pre);
                break;
            }
            
            if(pre != target[i]) {
                answer.append(count);
                answer.append(pre);
                
                pre = target[i];
                count = 1;
            } else {
                count++;
            }
        }
        
        return answer;
    }
}
