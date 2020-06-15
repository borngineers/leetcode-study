public class LeetCode125 {
    /**
     * 125. Valid Palindrome
     * https://leetcode.com/problems/valid-palindrome/
     *
     * Example 1:
     * Input: "A man, a plan, a canal: Panama"
     * Output: true
     *
     * Example 2:
     * Input: "race a car"
     * Output: false
     * */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(solution.isPalindrome("race a car")); // false
        System.out.println(solution.isPalindrome("0P")); // false
    }

    static class Solution {
        // 4 ms , 40.7 MB
        public boolean isPalindrome(String s) {
            char[] charArray = s.toLowerCase().toCharArray();
            int size = charArray.length;

            int start = 0;
            int end = size - 1;

            while (start < end) {
                if (!isAlphabet(charArray[start])) {
                    start++;
                    continue;
                }
                if (!isAlphabet(charArray[end])) {
                    end--;
                    continue;
                }
                if (charArray[start] == charArray[end]) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
            return true;
        }

        public boolean isAlphabet(char c) {
            return ('a' <= c && c <= 'z') || ('0' <= c && c <= '9');
        }
    }
}
