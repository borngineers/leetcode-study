package leetcode.week06;

import java.util.HashMap;
import java.util.Map;

public class S013 {

    public static void main(String[]args){
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {

        final Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        final int size = s.length();
        int sum = 0;

        for(int i = 0; i < size; i++){
            final char pre = s.charAt(i);
            final int preValue = map.get(pre);

            if(i + 1 >= size) {
                sum += preValue;
                continue;
            }

            final char post = s.charAt(i+1);
            final int postValue = map.get(post);

            if(preValue < postValue){
                sum += postValue - preValue;
                i++;
            } else {
                sum += preValue;
            }
        }

        return sum;
    }
}
