package week04;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static void main(String[]args) {

        System.out.println(romanToIntSecondWay("III"));

        System.out.println(romanToIntSecondWay("IV"));

        System.out.println(romanToIntSecondWay("LVIII"));

        System.out.println(romanToIntSecondWay("MCMXCIV"));

    }

    static int romanToIntFirstWay(String s) {

        Map<String, Integer> romanMap = new HashMap<String,Integer>(){{
            put("I", 1);
            put("IV", 4);
            put("V", 5);
            put("IX", 9);
            put("X", 10);
            put("XL", 40);
            put("L", 50);
            put("XC", 90);
            put("C", 100);
            put("CD", 400);
            put("D", 500);
            put("CM", 900);
            put("M", 1000);
        }};

        int resultValue = 0;

        final int size = s.length();

        for(int i = 0; i < size; i++) {

            String roman = s.charAt(i) + "";

            if(i + 1 < size) {
                Integer value = romanMap.get(roman + s.charAt(i+1));
                if(value != null){
                    resultValue += value;
                    i++;
                    continue;
                }
            }

            resultValue += romanMap.get(roman);
        }

        return resultValue;
    }

    static int romanToIntSecondWay(String s) {

        Map<Character, Integer> romanMap = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};


        final int size = s.length();
        final int[]numbers = new int[size];

        for(int i = 0; i < size; i++) {

            char roman = s.charAt(i);
            numbers[i] = romanMap.get(roman);
        }

        int resultValue = 0;

        for(int i = 0; i < size; i++){
            if((i+1) < size && numbers[i] < numbers[i + 1]){
                resultValue += numbers[i + 1] - numbers[i];
                i++;
            } else {
                resultValue += numbers[i];
            }
        }

        return resultValue;
    }
}
