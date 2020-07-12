package p17;

import java.util.*;

class Solution {
    private String digits;
    private final List<String> answer = new ArrayList<>();
    private final Map<Character, List<Character>> map = new HashMap<>();

    Solution() {
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return answer;
        }
        this.digits = digits;
        bruteForce(0, new char[digits.length()]);
        return answer;
    }

    private void bruteForce(int index, char[] chars) {
        if (index == digits.length()) {
            answer.add(String.valueOf(chars));
            return;
        }
        for (Character character : map.get(digits.charAt(index))) {
            chars[index] = character;
            bruteForce(index + 1, chars);
        }
    }
}