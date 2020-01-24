package week04;

public class ClimbStairs {

    public static void main(String[]args) {

    }

    public static int climbStairs(int n) {

        /**
         * 두가지 조건
         * 1 step 으로 climb
         * 2 step 으로 climb 하여서 n 을 만든다.
         *
         * n 을 만들기 위한 가지수 계산 => DP 를 이용 기저사례
         */

        // 기저사례를 이용.
        // n = 1 => 1 (1개)
        // n = 2 => 1 + 1, 2 (2개)
        // n = 3 => 1 + 1 + 1, 2 + 1, 1 + 2 (3개)
        // n = 4 => 1 + 1 + 1 + 1, 2 + 1 + 1, 1 + 2 + 1, 1 + 1 + 2, 2 + 2 (5개)

        int[]climbResult = new int[10000];

        climbResult[1] = 1;
        climbResult[2] = 2; // climbResult[1]의 결과에 + 1, 2
        climbResult[3] = 3; // climbResult[1]의 결과에 + 2, climbResult[2]의 결과에 + 1
        climbResult[4] = 5; // climbResult[2]의 결과에 + 2, climbResult[3]의 결과에 + 1

        // climbResult[n] = climbResult[n-2] + climbResult[n-1]

        for(int i = 5; i < 10000; i++){
            climbResult[i] = climbResult[i-2] + climbResult[i-1];
        }

        return climbResult[n];
    }
}
