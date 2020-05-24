package published.p13;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<Character, Integer> map = new HashMap<>();

    public Solution() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == 'I' && i + 1 < s.length()) {
                if (s.charAt(i + 1) == 'V') {
                    answer += 4;
                    i++;
                    continue;
                }
                if (s.charAt(i + 1) == 'X') {
                    answer += 9;
                    i++;
                    continue;
                }
            }
            else if (temp == 'X' && i + 1 < s.length()) {
                if (s.charAt(i + 1) == 'L') {
                    answer += 40;
                    i++;
                    continue;
                }
                if (s.charAt(i + 1) == 'C') {
                    answer += 90;
                    i++;
                    continue;
                }
            }
            else if (temp == 'C' && i + 1 < s.length()) {
                if (s.charAt(i + 1) == 'D') {
                    answer += 400;
                    i++;
                    continue;
                }
                if (s.charAt(i + 1) == 'M') {
                    answer += 900;
                    i++;
                    continue;
                }
            }
            answer += map.get(temp);
        }
        return answer;
    }
}