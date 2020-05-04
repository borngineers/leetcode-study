package solved.p146;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LRUCache {
    private Map<Integer, Integer> map = new HashMap<>();
    private List<Integer> list = new ArrayList<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove(new Integer(key));
            list.add(key);
        }
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(new Integer(key));
        } else {
            if (list.size() == capacity) {
                map.remove(list.remove(0));
            }
        }
        list.add(key);
        map.put(key, value);
    }
}