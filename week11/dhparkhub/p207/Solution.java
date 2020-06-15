package solved.p207;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] topology = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0];
            int y = prerequisite[1];
            topology[x]++;
            graph.get(y).add(x);
        }

        int count = 0;
        while (count < numCourses) {
            boolean courseTaken = false;
            for (int i = 0; i < numCourses; i++) {
                if (topology[i] == 0) {
                    List<Integer> list = graph.get(i);
                    for (Integer x : list) {
                        topology[x]--;
                    }
                    topology[i]--;
                    courseTaken = true;
                    count++;
                }
            }
            if (!courseTaken) break;
        }

        return count == numCourses;
    }
}