package leetcode.week04;

import java.util.*;

public class S743 {

    public static void main(String[]args) {
        System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
//        System.out.println(networkDelayTime(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2));
    }

    public static int networkDelayTime(int[][] times, int N, int K) {
        final Map<Integer, List<int[]>> nodeSet = new HashMap<>();

        // reference : https://github.com/YaokaiYang-assaultmaster/LeetCode/blob/master/LeetcodeAlgorithmQuestions/743.%20Network%20Delay%20Time.md
        for(int[]edge : times) {
            nodeSet.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        final Map<Integer, Integer> dist = new HashMap<>();
        final PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));

        // node number, delay time
        minHeap.offer(new int[]{K, 0});

        while(!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            if (dist.containsKey(current[0])){
                continue;
            }

            // map 에 넣음으로써 방문 및 시간 설정
            dist.put(current[0], current[1]);

            // 현재 노드에서 이동할 노드들을 pq 에 삽입
            if(nodeSet.containsKey(current[0])){
                for(int[] edge : nodeSet.get(current[0])){
                    minHeap.offer(new int[]{edge[0], edge[1] + current[1]});
                }
            }
        }

        if(dist.size() != N) {
            return -1;
        }

        int ret = Integer.MIN_VALUE;
        for(int k : dist.keySet()){
            ret = Math.max(ret, dist.get(k));
        }

        return ret;
    }
}

