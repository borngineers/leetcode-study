package week06;

import java.util.Arrays;
import java.util.Comparator;

public class MinSetSize {

    public static void main(String[]args) {
        minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7});
    }

    public static int minSetSize(int[] arr) {

        /**
         * (1) 어떤 배열이 존재한다.
         * (2) 그 배열에 중복된 수가 존재한다.
         * (3) 중복된 수를 제거하였을때 남은 수들의 개수가, 주어진 배열의 같거나 적어야 한다.
         * (4) 최소한 몇개 수를 제거해야 하는가?
         */

        // 0 ~ 100000
        final Integer[] count = new Integer[100002];

        for(int i = 0; i <= 100001; i++){
            count[i] = 0;
        }

        for(int number : arr){
            count[number]++;
        }

        // 내림차순
        Arrays.sort(count, Comparator.reverseOrder());

        final int size = arr.length;
        final int half = size / 2;
        int tempSize = arr.length;

        int result = 0;

        for(int c : count) {

            if(half >= tempSize - c) {
                result++;
                break;
            } else {
                result++;
                tempSize -= c;
            }
        }


        return result;
    }
}
