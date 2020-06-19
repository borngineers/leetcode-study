import java.util.*;

public class LeetCode387 {
    /**
     * 387. First Unique Character in a String
     * https://leetcode.com/problems/first-unique-character-in-a-string/
     *
     * Examples:
     * s = "leetcode"
     * return 0.
     *
     * s = "loveleetcode",
     * return 2.
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.firstUniqChar("leetcode");
        System.out.println(result);

        result = solution.firstUniqChar("loveleetcode");
        System.out.println(result);

        result = solution.firstUniqChar("aaa");
        System.out.println(result);
    }

    static class Solution {
        // Runtime: 61 ms, faster than 5.02% of Java online submissions for First Unique Character in a String.
        // Memory Usage: 40.4 MB, less than 17.17% of Java online submissions for First Unique Character in a String.
        public int firstUniqChar(String s) {
            char[] charList = s.toCharArray();
            int lastIdx = -1;
            Map<Character, Integer> charMap = new LinkedHashMap<>();
            List<Character> blackList = new ArrayList<>();

            for (int i = 0; i < charList.length; i++) {
                char c = charList[i];
                if (blackList.contains(c)) {
                    continue;
                }
                if (charMap.containsKey(c)) {
                    charMap.remove(c);
                    if (!blackList.contains(c)) {
                        blackList.add(c);
                    }
                    continue;
                }
                charMap.put(c, i);
            }

            for (char c : charMap.keySet()) {
                lastIdx = charMap.getOrDefault(c, -1);
                break;
            }

            return lastIdx;
        }

    }

}
