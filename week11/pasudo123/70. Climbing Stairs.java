package leetcode.week07;

public class S070 {
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(10));
        System.out.println(climbStairs(100));
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {

        if(n == 1){return 1;}
        if(n == 2){return 2;}

        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        /**
         * n 을 가는 방법
         * - (n-1) 을 가는 방법에서 + 1 을 더해준다.
         * - (n-2) 을 가는 방법에서 + 2 를 더해준다.
         */
        return recursive(n-1, n-2, dp);
    }

    private static int recursive(final int pre, final int preDouble, final int[]dp){

        if(dp[pre] == 0){
            dp[pre] = recursive(pre - 1, pre - 2, dp);
        }
        if(dp[preDouble] == 0){
            dp[preDouble] = recursive(preDouble - 1, preDouble - 2, dp);
        }

        return dp[pre] + dp[preDouble];
    }
}
