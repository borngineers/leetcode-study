package published.p70;

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