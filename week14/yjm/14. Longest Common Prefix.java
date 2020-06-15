import java.util.Arrays;

public class LeetCode14 {
    /**
     * 14. Longest Common Prefix
     * https://leetcode.com/problems/longest-common-prefix/
     *
     * Example 1:
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     *
     * Example 2:
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        String result = solution.longestCommonPrefix2(new String[]{"flower","flow","flight"});
        System.out.println(result);

        result = solution.longestCommonPrefix2(new String[]{"dog","racecar","car"});
        System.out.println(result);

        result = solution.longestCommonPrefix2(new String[]{});
        System.out.println(result);
    }

    static class Solution {
        // Runtime: 4 ms, faster than 24.11% of Java online submissions for Longest Common Prefix.
        // Memory Usage: 37.4 MB, less than 96.49% of Java online submissions for Longest Common Prefix.
        public String longestCommonPrefix(String[] strs) {
            if (strs.length < 1) { return ""; }
            int shortestLen = Integer.MAX_VALUE;
            for (int i = 0; i < strs.length; i++) {
                if (shortestLen > strs[i].length()) {
                    shortestLen = strs[i].length();
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < shortestLen; i++) {
                int finalI = i;
                char baseChar = strs[0].charAt(i);
                if (Arrays.stream(strs).allMatch(s -> s.charAt(finalI) == baseChar)) {
                    sb.append(baseChar);
                } else {
                    break;
                }
            }
            return sb.toString();
        }
    }
}
