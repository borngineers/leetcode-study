package leetcode.week08;

import java.util.Arrays;

public class S204 {
    public static void main(String[] args) {
        System.out.println(countPrimes(2));
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(100));
        System.out.println(countPrimes(1000));
    }

    public static int countPrimes(int n) {

        final boolean[] isPrimeArray = new boolean[n];
        Arrays.fill(isPrimeArray, true);
        int count = 0;
        for(int i = 2; i < n; i++){
            if(!isPrimeArray[i]){
                continue;
            }

            isPrimeArray[i] = true;
            count++;
            for(int j = i + i; j < n; j = j + i){
                isPrimeArray[j] = false;
            }
        }

        return count;
    }
}
