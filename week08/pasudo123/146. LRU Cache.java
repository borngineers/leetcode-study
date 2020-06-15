package leetcode.week04;

import java.util.*;

public class S146 {

    public static void main(String[]args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println(cache.get(2));       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4

        cache.put(2, 1);
        cache.put(1, 1);
        System.out.println(cache.get(2));
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    static class LRUCache {

        final int capacity;
        int currentTime = 0;
        int lastUsedTime = -1;
        Map<Integer, Integer> cacheTable = new HashMap<>();
        Map<Integer, Integer> timeTable = new HashMap<>();
        Map<Integer, Integer> reverseTimeTable = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            currentTime++;
            int ret = cacheTable.getOrDefault(key, -1);
            if(ret != -1){
                Integer localLastUsedTime = reverseTimeTable.get(key);
                timeTable.remove(localLastUsedTime);

                reverseTimeTable.put(key, currentTime);
                timeTable.put(currentTime, key);
            }
            return ret;
        }


        public void put(int key, int value) {
            currentTime++;

            if(lastUsedTime == -1){
                lastUsedTime = currentTime;
            }

            if(cacheTable.containsKey(key)){
                Integer localLastUsedTime = reverseTimeTable.get(key);
                timeTable.remove(localLastUsedTime);

                cacheTable.put(key, value);
                timeTable.put(currentTime, key);
                reverseTimeTable.put(key, currentTime);
                return;
            }

            if(cacheTable.size() >= capacity){
                // 시간복잡도
                while(!timeTable.containsKey(lastUsedTime)){ lastUsedTime++; }
                Integer lastUsedKey = timeTable.get(lastUsedTime++);
                cacheTable.remove(lastUsedKey);
            }

            cacheTable.put(key, value);
            timeTable.put(currentTime, key);
            reverseTimeTable.put(key, currentTime);
        }
    }
}
