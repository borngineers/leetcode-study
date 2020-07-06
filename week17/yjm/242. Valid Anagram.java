// Runtime: 15 ms, faster than 13.78% of Java online submissions for Valid Anagram.
// Memory Usage: 40.9 MB, less than 12.63% of Java online submissions for Valid Anagram.

import java.util.HashMap;

public class LeetCode242 {
    /**
     * 242. Valid Anagram
     * https://leetcode.com/problems/valid-anagram/
     *
     * Example 1:
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     *
     * Example 2:
     * Input: s = "rat", t = "car"
     * Output: false
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        boolean result = solution.isAnagram("anagram", "nagaram");  // 3
        System.out.println(result);
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            char[] sList = s.toCharArray();
            char[] tList = t.toCharArray();

            HashMap<Character, Integer> charCounter = new HashMap<>();

            for (int i = 0; i < sList.length; i++) {
                if (charCounter.containsKey(sList[i])) {
                    charCounter.put(sList[i], charCounter.get(sList[i]) + 1);
                } else {
                    charCounter.put(sList[i], 1);
                }
            }

            for (int i = 0; i < tList.length; i++) {
                if (!charCounter.containsKey(tList[i])) { return false; }
                charCounter.put(tList[i], charCounter.get(tList[i]) - 1);
                if (charCounter.get(tList[i]) == 0) { charCounter.remove(tList[i]); };
            }

            if (charCounter.size() > 0) { return false; }
            return true;

        }
    }
}
