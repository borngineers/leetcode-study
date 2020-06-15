package problem1953;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Resolver resolver = new Resolver();
        int t, n, m, r, c, l;
        int[][] map = new int[50][50];

        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            r = scanner.nextInt();
            c = scanner.nextInt();
            l = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    map[j][k] = scanner.nextInt();
                }
            }
            resolver.init(n, m, r, c, l, map);
            int answer = resolver.resolve();
            System.out.println(String.format("#%d %d", i, answer));
        }
    }

    static class Resolver {

        int n, m, r, c, l;
        int[][] map;
        boolean[][] visited = new boolean[50][50];

        class Point {
            int r, c, l;

            Point(int r, int c, int l) {
                this.r = r;
                this.c = c;
                this.l = l;
            }
        }

        void init(int n, int m, int r, int c, int l, int[][] map) {
            this.n = n;
            this.m = m;
            this.r = r;
            this.c = c;
            this.l = l;
            this.map = map;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    visited[i][j] = false;
                }
            }
        }

        boolean valid(int r, int c, int l) {
            return r >= 0 && r < n && c >= 0 && c < m && l <= this.l;
        }

        int getMaxDistance() {
            int ret = 0;

            Point p = new Point(r, c, 1);
            visited[r][c] = true;

            Queue<Point> q = new LinkedList<>();
            q.add(p);
            while (!q.isEmpty()) {
                Point tmp = q.peek();
                q.poll();
                ret++;

                int pipe = map[tmp.r][tmp.c];
                if (pipe == 1 || pipe == 3 || pipe == 4 || pipe == 5) {
                    int mr = tmp.r;
                    int mc = tmp.c + 1;
                    int ml = tmp.l + 1;
                    if (valid(mr, mc, ml) && !visited[mr][mc]) {
                        int mpipe = map[mr][mc];
                        if (mpipe == 1 || mpipe == 3 || mpipe == 6 || mpipe == 7) {
                            q.add(new Point(mr, mc, ml));
                            visited[mr][mc] = true;
                        }
                    }
                }
                if (pipe == 1 || pipe == 2 || pipe == 5 || pipe == 6) {
                    int mr = tmp.r + 1;
                    int mc = tmp.c;
                    int ml = tmp.l + 1;
                    if (valid(mr, mc, ml) && !visited[mr][mc]) {
                        int mpipe = map[mr][mc];
                        if (mpipe == 1 || mpipe == 2 || mpipe == 4 || mpipe == 7) {
                            q.add(new Point(mr, mc, ml));
                            visited[mr][mc] = true;
                        }
                    }
                }
                if (pipe == 1 || pipe == 3 || pipe == 6 || pipe == 7) {
                    int mr = tmp.r;
                    int mc = tmp.c - 1;
                    int ml = tmp.l + 1;
                    if (valid(mr, mc, ml) && !visited[mr][mc]) {
                        int mpipe = map[mr][mc];
                        if (mpipe == 1 || mpipe == 3 || mpipe == 4 || mpipe == 5) {
                            q.add(new Point(mr, mc, ml));
                            visited[mr][mc] = true;
                        }
                    }
                }
                if (pipe == 1 || pipe == 2 || pipe == 4 || pipe == 7) {
                    int mr = tmp.r - 1;
                    int mc = tmp.c;
                    int ml = tmp.l + 1;
                    if (valid(mr, mc, ml) && !visited[mr][mc]) {
                        int mpipe = map[mr][mc];
                        if (mpipe == 1 || mpipe == 2 || mpipe == 5 || mpipe == 6) {
                            q.add(new Point(mr, mc, ml));
                            visited[mr][mc] = true;
                        }
                    }
                }
            }
            return ret;
        }

        int resolve() {
            return getMaxDistance();
        }

    }

}