package published.p202;

import java.util.HashMap;
import java.util.Map;

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