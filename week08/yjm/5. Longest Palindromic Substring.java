public class LeetCode5 {
    /**
     * 5. Longest Palindromic Substring
     * https://leetcode.com/problems/longest-palindromic-substring/
     *
     * Example 1:
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     *
     * Example 2:
     * Input: "cbbd"
     * Output: "bb"
     * */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("")); //
        System.out.println(solution.longestPalindrome("a")); // a
        System.out.println(solution.longestPalindrome("bb")); // bb
        System.out.println(solution.longestPalindrome("ccc")); // ccc
        System.out.println(solution.longestPalindrome("abb")); // bb
        System.out.println(solution.longestPalindrome("aav")); // aa
        System.out.println(solution.longestPalindrome("babad")); // bab
        System.out.println(solution.longestPalindrome("cbbd")); // bb
        System.out.println(solution.longestPalindrome("abcda")); // a
        System.out.println(solution.longestPalindrome("absvce")); // a
    }

    static class Solution {
        public String longestPalindrome(String s) {
            String ret = "";
            char[] chr = s.toCharArray();
            boolean[][] dp = new boolean[chr.length][chr.length];
            int maxN = 0;

            for(int i = chr.length - 1; i >= 0; i--) {
                for(int j = i; j < chr.length; j++) {
                    dp[i][j] = (chr[i] == chr[j] && (j - i <= 2 || dp[i + 1][j - 1]));
                    if(dp[i][j] && j - i >= maxN) {
                        maxN = j - i;
                        ret = s.substring(i, j + 1);
                    }
                }
            }
            return ret;
        }
    }
}
