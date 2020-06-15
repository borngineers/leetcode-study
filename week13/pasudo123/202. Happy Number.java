package leetcode.week06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S202 {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
//        System.out.println(isHappy(1));
//        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        final Map<Long, Object> duplicate = new HashMap<>();
        final List<Integer> list = new ArrayList<>();

        long currentN = (long)n;

        if(currentN == 1){
            return true;
        }

        duplicate.put((long)n, new Object());

        while(true){
            int value = (int) (currentN % 10);
            list.add(value);
            currentN /= 10;

            if(currentN != 0){
                continue;
            }

            long sum = 0;
            for(int element : list){
                sum += element * element;
            }

            if(duplicate.containsKey(sum)){
                return false;
            }

            duplicate.put(sum, new Object());

            currentN = sum;
            list.clear();

            if(currentN == 1L){
                break;
            }
        }

        return true;
    }
}
