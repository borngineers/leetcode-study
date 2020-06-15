package solved.p743;

import java.util.*;

class Solution {
    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final List<List<Pair>> graph = new ArrayList<>();
    private int[] cache;

    public int networkDelayTime(int[][] times, int N, int K) {
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        cache = new int[N];
        Arrays.fill(cache, -1);

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];
            graph.get(u).add(new Pair(v, w));
        }

        bfs(K - 1);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (cache[i] == -1) return -1;
            answer = Math.max(answer, cache[i]);
        }
        return answer;
    }

    private void bfs(int x) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (cache[p.x] != -1 && p.y >= cache[p.x]) {
                continue;
            }
            cache[p.x] = p.y;

            for (Pair np : graph.get(p.x)) {
                q.add(new Pair(np.x, p.y + np.y));
            }
        }
    }
}