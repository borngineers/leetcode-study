package published.p387;

class Solution {
    private final int[] countMap = new int[26];
    private final int[] indexMap = new int[26];

    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (countMap[index] == 0) {
                indexMap[index] = i;
            }
            countMap[index]++;
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (countMap[i] == 1) {
                answer = Math.min(answer, indexMap[i]);
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}

//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//class Solution {
//    private final Map<Character, Integer> countMap = new LinkedHashMap<>();
//    private final Map<Character, Integer> indexMap = new HashMap<>();
//
//    public int firstUniqChar(String s) {
//        if (s.length() == 0) return -1;
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (indexMap.containsKey(ch)) {
//                countMap.remove(ch);
//                continue;
//            }
//            countMap.put(ch, 1);
//            indexMap.put(ch, i);
//        }
//        if (countMap.isEmpty()) return -1;
//        char ch = countMap.keySet().iterator().next();
//        return indexMap.get(ch);
//    }
//}

//import java.util.HashMap;
//import java.util.Map;
//
//class Solution {
//    private final Map<Character, Integer> cache = new HashMap<>();
//
//    public int firstUniqChar(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            cache.put(ch, cache.getOrDefault(ch, 0) + 1);
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (cache.get(s.charAt(i)) == 1) return i;
//        }
//        return -1;
//    }
//}