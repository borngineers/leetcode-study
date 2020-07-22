package p139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private String s;
    private List<String> wordDict;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        return wordBreak(0, new HashSet<Integer>());
    }

    private boolean wordBreak(int index, Set<Integer> indexMap) {
        if (index == s.length()) {
            return true;
        }
        if (indexMap.contains(index)) {
            return false;
        }
        for (String word : wordDict) {
            if (s.startsWith(word, index)) {
                if (wordBreak(index + word.length(), indexMap)) {
                    return true;
                }
            }
        }
        indexMap.add(index);
        return false;
    }
}