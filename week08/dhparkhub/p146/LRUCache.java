package solved.p146;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    private final Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        int ret = cache.getOrDefault(key, -1);
        if (ret != -1) {
            cache.remove(key);
            cache.put(key, ret);
        }
        return ret;
    }

    public void put(int key, int value) {
        cache.remove(key);
        cache.put(key, value);
    }
}