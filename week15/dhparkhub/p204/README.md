# [Leetcode] 204. Count Primes

주어진 `N`보다 작은 수 중에서 소수의 개수를 찾아 반환한다.

## Solution

[에라토스테네스의 체](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)를 사용하여 `N`보다 작은 소수를 모두 찾아 그 개수를 반환한다.

```java
class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        // seize of eratosthenes
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) continue;
            for (int j = i * 2; j < n; j += i) {
                prime[j] = false;
            }
        }

        int count = 0;
        for (int i=2; i<n; i++) {
            count = prime[i] ? count + 1 : count;
        }

        return count;
    }
}
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 13 ms | 37.7 MB |
