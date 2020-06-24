package published.p204;

import java.util.Arrays;

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