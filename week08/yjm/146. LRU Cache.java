import java.util.HashMap;
import java.util.Map;

public class LeetCode146 {
    /**
     * 146. LRU Cache
     * https://leetcode.com/problems/lru-cache/
     *
     * Example:
     * LRUCache cache = new LRUCache( 2 ); // capacity
     * cache.put(1,1);
     * cache.put(2,2);
     * cache.get(1);       // returns 1
     * cache.put(3,3);    // evicts key 2
     * cache.get(2);       // returns -1 (not found)
     * cache.put(4,4);    // evicts key 1
     * cache.get(1);       // returns -1 (not found)
     * cache.get(3);       // returns 3
     * cache.get(4);       // returns 4
     * */

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

    static class LRUCache {
        private final int MAX;
        private int life = 0;
        private HashMap<Integer, Pair> cacheMap = new HashMap<>();
        public LRUCache(int capacity) {
            this.MAX = capacity;
        }

        public int get(int key) {
            int retVal = -1;
            if (cacheMap.containsKey(key)) {
                Pair item = cacheMap.get(key);
                life += 1;
                item.count = life;
                cacheMap.put(key, item);
                retVal = item.val;
            } else {
                retVal = -1;
            }
            return retVal;
        }

        public void put(int key, int value) {
            int minKey = -1;
            int minVal = -1;
            life += 1;
            if (!cacheMap.containsKey(key)) {
                if (cacheMap.size() >= MAX) {
                    for (Map.Entry item : cacheMap.entrySet()) {
                        Pair p = (Pair) item.getValue();
                        int pKey = (int) item.getKey();
                        if (minVal == -1) {
                            minVal = p.count;
                            minKey = pKey;
                        } else {
                            if (minVal > p.count) {
                                minVal = p.count;
                                minKey = pKey;
                            }
                        }
                    }
                    cacheMap.remove(minKey);
                }
            }
            cacheMap.put(key, new Pair(value, life));
        }
    }

    static class Pair {
        int val = 0;
        int count = 0;
        public Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
