package sw1952;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        final String format = "#%d %d";

        for (int test_case = 1; test_case <= T; test_case++) {
            final int N = sc.nextInt();
            final int K = sc.nextInt();
            final int[][] map = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            HikingTrailMachine hikingTrailMachine = new HikingTrailMachine(N, K, map);
            System.out.println(String.format(format, test_case, hikingTrailMachine.getMaxHikingValue()));
        }
    }

    static class HikingTrailMachine{
        private int N;
        private int K;
        private int[][] map;
        private int[][] visited;
        private int max = 0;

        private int[]move1 = new int[] {-1, 1, 0, 0};
        private int[]move2 = new int[] {0, 0, -1, 1};

        public HikingTrailMachine(int N, int K, int[][] map){
            this.N = N;
            this.K = K;
            this.map = map;
            this.visited = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    visited[i][j] = 0;
                }
            }
        }

        public int getMaxHikingValue(){
            final List<Point> points = getMaxHeightPoint();
            points.forEach(point -> {
                visited[point.i][point.j] = 1;
                dfs(point.i, point.j, true, 1);
                visited[point.i][point.j] = 0;
            });
            return max;
        }

        private void dfs(int i, int j, boolean isDrillPossible, int currentValue){

            for(int seq = 0; seq < 4; seq++) {
                int mi = move1[seq] + i;
                int mj = move2[seq] + j;

                if(mi < 0 || mi >= N || mj < 0 || mj >= N) {
                    continue;
                }

                int currentHeight = map[i][j];
                int anotherHeight = map[mi][mj];

                if(currentHeight > anotherHeight && visited[mi][mj] == 0){
                    visited[mi][mj] = 1;
                    dfs(mi, mj, isDrillPossible, currentValue + 1);
                    visited[mi][mj] = 0;
                } else {
                    // currentHeight <= map[mi][mj]
                    if(isDrillPossible && anotherHeight - K < currentHeight && visited[mi][mj] == 0){
                        map[mi][mj] -= K;
                        visited[mi][mj] = 1;
                        dfs(mi, mj, false, currentValue + 1);
                        visited[mi][mj] = 0;
                        map[mi][mj] += K;
                    }
                }
            }

            max = Math.max(max, currentValue);
        }

        private List<Point> getMaxHeightPoint(){
            int maxHeight = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    maxHeight = Math.max(map[i][j], maxHeight);
                }
            }

            final List<Point> points = new ArrayList<>();

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(maxHeight == map[i][j]){
                        points.add(new Point(i, j));
                    }
                }
            }

            return points;
        }

        class Point{
            int i;  // 행
            int j;  // 열
            public Point(int i, int j){
                this.i = i;
                this.j = j;
            }
        }
    }
}
