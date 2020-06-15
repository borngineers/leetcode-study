public class LeetCode3 {
    /**
     * 3. Longest Substring Without Repeating Characters
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     *
     * Example 1:
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * Example 2:
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Example 3:
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * */
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("bbbbb"); // 3
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int startIdx = 0;
            int maxLen = 0;
            int sSize = s.length();
            String subStr = "";

            for (int i = 0; i < sSize; i++) {
                int charIdx = subStr.indexOf(s.charAt(i));
                if (charIdx != -1) {
                    startIdx = startIdx + charIdx + 1;
                } else {

                }
                subStr = s.substring(startIdx, i + 1);
                maxLen = Math.max(maxLen, subStr.length());
            }

            System.out.println(maxLen);
            return maxLen;
        }
    }
}
