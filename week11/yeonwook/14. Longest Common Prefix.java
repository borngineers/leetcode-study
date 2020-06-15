
class Solution {
    public String longestCommonPrefix(String[] strs) {
		
        int len = strs.length;
        
        if(len == 0) return "";
        if(len == 1) return strs[0];
        
        char[] arr = strs[0].toCharArray();
        
        if(arr.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<len; i++) {
            
            int j = 0;
            sb.setLength(0);
            
            while(true) {
                if(j == arr.length || j == strs[i].length()) break;
                
                if(arr[j] == strs[i].charAt(j)) sb.append(arr[j]);
                else break;
                
                j++;
            }
            
            if(sb.length()==0) return "";
            
            arr = sb.toString().toCharArray();
        }
        
        return sb.toString();
    }
}
