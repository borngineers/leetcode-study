# [Leetcode] 387. First Unique Character in a String

주어진 문자열에서 2번 이상 등장하지 않는 첫 번째 문자의 인덱스를 반환한다.

## Solution

문자열을 순차적으로 탐색하면서 임의의 문자에 대해 출현 횟수를 카운트하고 해당 문자가 처음에 등장한 인덱스를 저장한다. 문자열은 오직 소문자만 포함한다는 조건이 있기 때문에 `a`부터 `z`까지 탐색하면서 1번만 출현한 문자의 최초 인덱스를 반환한다.

```java
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
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 7 ms | 39.8 MB |
