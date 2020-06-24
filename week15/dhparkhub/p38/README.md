# [Leetcode] 38. Count and Say

문제의 주어진 조건대로 `N` 번째 시퀀스 문자열을 구한 뒤 반환한다.

## Solution

임의의 `N` 번째 시퀀스 문자열은 임의의 `N-1` 번째 시퀀스 문자열을 통해 구할 수 있다. `N-1` 번째 시퀀스 문자열을 순차적으로 탐색하면서 임의의 숫자에 대해 해당 숫자가 연속한 횟수를 카운트하여 카운트한 값과 해당 숫자를 문자열에 이어붙인다.

```java
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int k = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                k++;
            }
            sb.append(String.format("%d%c", k, s.charAt(i)));
            i++;
        }
        return sb.toString();
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| - | 28 ms | 39.4 MB |
