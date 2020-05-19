package solved.p1424;

import java.util.*;

class Solution {
    private final Map<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int totalSize = 0;
        for (int i = 0; i < nums.size(); i++) {
            totalSize += nums.get(i).size();
            for (int j = 0; j < nums.get(i).size(); j++) {
                int key = i + j;
                int value = nums.get(i).get(j);
                LinkedList<Integer> list = map.getOrDefault(key, new LinkedList<Integer>());
                list.addFirst(value);
                map.put(key, list);
            }
        }

        int[] answer = new int[totalSize];
        int index = 0;
        for (int key : map.keySet()) {
            for (int i : map.get(key)) {
                answer[index++] = i;
            }
        }

        return answer;
    }
}