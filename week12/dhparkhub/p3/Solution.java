package published.p3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<Character, Integer> indexMap = new HashMap<>();

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            if (indexMap.containsKey(tempChar) && indexMap.get(tempChar) >= startIndex) {
                maxLength = Math.max(maxLength, i - startIndex);
                startIndex = indexMap.get(tempChar) + 1;
            }
            indexMap.put(tempChar, i);
        }
        return Math.max(maxLength, s.length() - startIndex);
    }
}