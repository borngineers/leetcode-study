// Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse String.
// Memory Usage: 46.4 MB, less than 40.64% of Java online submissions for Reverse String.
class Solution {
    public void reverseString(char[] s) {
        int startIdx = 0;
        int endIdx = s.length - 1;
        
        while (startIdx < endIdx) {
            
            char temp = s[startIdx];
            s[startIdx] = s[endIdx];
            s[endIdx] = temp;
            
            startIdx++;
            endIdx--;
        }
    }
}
