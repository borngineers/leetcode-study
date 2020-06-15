package week03;

import java.util.*;

public class LeastInterval {

    public static void main(String[]args) {

        System.out.println(leastInterval(new char[]{'A', 'A', 'A'}, 2));

    }

    public static int leastInterval(char[] tasks, int n){

        final Map<Character, Integer> map = new HashMap<>();

        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());

        int cycles = 0;

        while(!pq.isEmpty()) {

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i <= n; i++){
                if(!pq.isEmpty()){
                    list.add(pq.remove());
                }
            }

            for(int element : list) {
                if(--element > 0) {
                    pq.add(element);
                }
            }

            cycles += pq.isEmpty() ? list.size() : n + 1;
        }

        return cycles;
    }
}
