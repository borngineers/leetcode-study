import java.util.*;

// NOT SOLVED
public class LeetCode743_2 {
    /**
     * 743. Network Delay Time
     * https://leetcode.com/problems/network-delay-time/
     *
     * Example 1:
     * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
     * Output: 2
     *
     * Note:
     * N will be in the range [1, 100].
     * K will be in the range [1, N].
     * The length of times will be in the range [1, 6000].
     * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.asdasd
     * */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2)); //2
        System.out.println(solution.networkDelayTime(new int[][]{{1,2,1}}, 2, 2)); // -1
        System.out.println(solution.networkDelayTime(new int[][]{{1,2,1}, {2,1,3}}, 2, 2)); // 3
        System.out.println(solution.networkDelayTime(new int[][]{{1,2,1}, {2,3,2}, {1,3,2}}, 3, 1)); // 2
        System.out.println(solution.networkDelayTime(new int[][]{{1,2,1}, {2,3,2}, {1,3,4}}, 3, 1)); // 3
        System.out.println(solution.networkDelayTime(new int[][]{{1,2,1}, {2,3,7}, {1,3,4}, {2,1,2}}, 3, 1)); // 4
        System.out.println(solution.networkDelayTime(new int[][]{{1,2,1}, {2,3,2}, {1,3,1}}, 3, 2)); // -1
    }

    static class Solution {
        HashMap<Integer, ArrayList<Pair>> mapList;
        int totalTime;
        boolean[] visited;
        public int networkDelayTime(int[][] times, int N, int K) {
            mapList = new HashMap<>();
            totalTime = -1;
            visited = new boolean[N+1];
            visited[0] = true;
            for (int[] sub : times) {
                Pair item = new Pair(sub[1], sub[2]);
                if (mapList.containsKey(sub[0])) {
                    mapList.get(sub[0]).add(item);
                } else {
                    mapList.put(sub[0], new ArrayList<>(Arrays.asList(item)));
                }
            }

            if (mapList.containsKey(K)) {
                ArrayList<Pair> checkList = getListOfNextNodesQueue(K);
                while (!isAllVisited(visited) && checkList.size() > 0) {
                    Pair minTimeNode = checkList.stream()
                            .min(Comparator.comparing(Pair::getTime))
                            .orElseThrow(NoSuchElementException::new);
                    visited[minTimeNode.dest] = true;
                    totalTime = minTimeNode.time;
                    checkList.remove(minTimeNode);

                    if (mapList.containsKey(minTimeNode.dest)) {
                        ArrayList<Pair> subList = mapList.get(minTimeNode.dest);
                        if (subList.size() > 0) {
                            for (Pair node : subList) {
                                if (visited[node.dest]) { continue; }
                                node.time += minTimeNode.time;
                                checkList.add(node);
                            }
                        }
                    }
                }
            }
            if (!isAllVisited(visited)) { return -1; }
            return totalTime;
        }

        public ArrayList<Pair> getListOfNextNodesQueue(int key) {
            visited[key] = true;
            return mapList.get(key);
        }

        public boolean isAllVisited(boolean[] visitInfo) {
            for (boolean visited : visitInfo) {
                if (!visited) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Pair {
        int dest = 0;
        int time = 0;

        public Pair(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }

        public int getDest() {
            return dest;
        }

        public void setDest(int dest) {
            this.dest = dest;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

}
