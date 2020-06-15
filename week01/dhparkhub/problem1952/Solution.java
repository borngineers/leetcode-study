package problem1952;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Resolver resolver = new Resolver();
        int t;
        int[] cost = new int[4];
        int[] plan = new int[12];

        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            for (int j = 0; j < 4; j++) {
                cost[j] = scanner.nextInt();
            }
            for (int j = 0; j < 12; j++) {
                plan[j] = scanner.nextInt();
            }
            resolver.init(cost, plan);
            int answer = resolver.resolve();
            System.out.println(String.format("#%d %d", i, answer));
        }
    }

    static class Resolver {

        int[] cost = new int[4];
        int[] plan = new int[12];

        void init(int[] cost, int[] plan) {
            this.cost = cost;
            this.plan = plan;
        }

        int getMinCost(int month, int total) {
            if (month >= 12) return total;
            if (plan[month] == 0) return getMinCost(month + 1, total);
            int case1 = getMinCost(month + 1, total + plan[month] * cost[0]);
            int case2 = getMinCost(month + 1, total + cost[1]);
            int case3 = getMinCost(month + 3, total + cost[2]);
            return Math.min(case1, Math.min(case2, case3));
        }

        int resolve() {
            return Math.min(cost[3], getMinCost(0, 0));
        }

    }

}