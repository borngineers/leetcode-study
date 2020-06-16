# [Leetcode] 70. Climbing Stairs

계단의 총 개수가 주어졌을 경우 계단을 올라가는 경우의 수를 반환한다.

## Solution

임의의 `n`번째 계단을 올라가는 방식은 `n-1`번 계단에서 1칸 올라오거나, `n-2`번 계단에서 2칸 올라오는 방법이 있다. 이를 점화식으로 표현하면 `f(n) = f(n-1) + f(n-2)`로 표현할 수 있고 한 번 계산한 `f(n)`은 캐시에 저장하여 바로 반환할 수 있도록 동적 계획법으로 문제를 해결한다.

```java
class Solution {
    private int[] cache;

    public int climbStairs(int n) {
        cache = new int[n + 1];
        return getClimbStairs(n);
    }

    private int getClimbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (cache[n] != 0) return cache[n];
        return cache[n] = getClimbStairs(n - 1) + getClimbStairs(n - 2);
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 0 ms | 36.1 MB |
