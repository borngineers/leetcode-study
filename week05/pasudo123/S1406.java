package leetcode.week02;

import java.util.Arrays;

public class S1406 {

    public static void main(String []args) {
        System.out.println(stoneGameIII((new int[]{1, 2, 3, 6})));
//        System.out.println(stoneGameIII((new int[]{1, 2, 3, -9})));
//        System.out.println(stoneGameIII((new int[]{-1, -2, -3})));
//        System.out.println(stoneGameIII((new int[]{1, 2, 3, -1, -2, -3, -7})));
    }

    public static String stoneGameIII(int[] stoneValue){
        int length = stoneValue.length;
        int[] dp = new int[length + 1];

        for(int i = length - 1; i >= 0; i--) {
            int take = 0;
            dp[i] = Integer.MIN_VALUE;

            for(int j = i; j < Math.min(length, i + 3); j++){
                take += stoneValue[j];
                dp[i] = Math.max(dp[i], take - dp[j+1]);
            }
        }

        int diff = dp[0];
        if(diff > 0) return "Alice";
        if(diff < 0) return "Bob";
        return "Tie";
    }


    public static String stoneGameIII_First(int[] stoneValue) {

        /**
         * top down 방식
         */

        int length = stoneValue.length;
        int[] sum = new int[length + 1];
        int[] dp = new int[length + 1];

        // 뒤에서부터 값을 순차적으로 더한 상태의 sum array 형성
        for(int i = length - 1; i >= 0; i--){
            sum[i] = sum[i+1] + stoneValue[i];
        }

        for(int i = length - 1; i >= 0; i--){
            dp[i] = stoneValue[i] + sum[i+1] - dp[i+1];

            System.out.println("\ndp array ==>");
            System.out.println(Arrays.toString(dp));

            // 돌멩이를 3개 집는 경우의 수 확인
            for(int k = i + 1; k < i + 3 && k < length; k++){
                dp[i] = Math.max(dp[i], sum[i]-dp[k+1]);
            }
        }

        System.out.println("===================================================");

        System.out.println("\ndp array ==> 최종 DP 값");
        System.out.println(Arrays.toString(dp));

        System.out.println("\nstone Values ==> 현재 들어온 돌멩이의 값");
        System.out.println(Arrays.toString(stoneValue));

        System.out.println("\nsum array ==> stone values 를 top down 으로 순차적으로 더해간 값");
        System.out.println(Arrays.toString(sum));

        if(dp[0] * 2 == sum[0]){
            return "Tie";
        }

        return (dp[0] * 2 > sum[0]) ? "Alice" : "Bob";
    }
}
