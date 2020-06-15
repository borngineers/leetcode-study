# [Leetcode] 202. Happy Number

주어진 숫자가 `Happy Number`인지 판별한다.

## Solution

문제에 주어진 대로 `happify` 함수를 정의한 후 주어진 숫자를 인자로 넘겨 메소드를 무한 반복한다. 이때, 사이클이 생기지 않고 `1`이 반환되면 `true`를 반환하고 아니라면 `false`를 반환한다.

```java
class Solution {
    private final Map<Integer, Boolean> cache = new HashMap<>();

    public boolean isHappy(int n) {
        while (n != 1 && !cache.containsKey(n)) {
            cache.put(n, true);
            n = happify(n);
        }
        return n == 1;
    }

    private int happify(int n) {
        int ret = 0;
        while (n != 0) {
            ret += Math.pow(n % 10, 2);
            n /= 10;
        }
        return ret;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| - | 1 ms | 36.4 MB |
