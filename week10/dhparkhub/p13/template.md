# [Leetcode] 13. Roman to Integer

`Roman` 숫자를 `Integer` 형태로 변환하여 반환한다.

## Solution

기본적으로 `Roman` 숫자(문자)와 숫자를 1대 1로 맵핑할 수 있게 `HashMap`에 저장한다. `Roman` 숫자를 순차적으로 탐색하면서 문자에 해당하는 숫자를 더해주면 되는데, `IV`, `IX`, `XL`, `XC`, `CD`, `CM`과 같은 경우는 특별하게 처리해주면 된다.

```java
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
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 5 ms | 40.3 MB |
