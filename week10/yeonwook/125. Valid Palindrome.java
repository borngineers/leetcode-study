class Solution {
    public boolean isPalindrome(String s) {
        
        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
        s = s.replaceAll(match, "");
        s = s.replaceAll(" ", "");
        s = s.toLowerCase();
        
        System.out.print(s);
        
        int len = s.length();
        if(len == 0 || len == 1) return true;
        
        char[] charArr = s.toCharArray();
        int left = 0;
        int right = len - 1;
        
        while(left<right) {
            
            if(charArr[left] != charArr[right]) {
                return false;
            } 
            
            left ++;
            right --;
        }
        
        return true;
    }
}
