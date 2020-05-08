import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetCode412 {
    /**
     * 412. Fizz Buzz
     * https://leetcode.com/problems/fizz-buzz/
     *
     * Example:
     * n = 15,
     * Return:
     * [
     *     "1",
     *     "2",
     *     "Fizz",
     *     "4",
     *     "Buzz",
     *     "Fizz",
     *     "7",
     *     "8",
     *     "Fizz",
     *     "Buzz",
     *     "11",
     *     "Fizz",
     *     "13",
     *     "14",
     *     "FizzBuzz"
     * ]
     * */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fizzBuzz(15)); // -321
    }

    static class Solution {
        public List<String> fizzBuzz1(int n) {
            List<String> result = new ArrayList<>();
            int fizz = 3;
            int buzz = 5;
            int position = 1;
            while (position <= n) {
                if (position % fizz == 0 && position % buzz == 0) {
                    result.add("FizzBuzz");
                } else if (position % fizz == 0) {
                    result.add("Fizz");
                } else if (position % buzz == 0) {
                    result.add("Buzz");
                } else {
                    result.add(position+"");
                }
                position++;
            }
            return result;
        }

        public List<String> fizzBuzz(int n) {
            List<String> result = IntStream.range(1, n+1)
                    .mapToObj(i -> {
                        if (i % 3 == 0 && i % 5 == 0) {
                            return "FizzBuzz";
                        } else if (i % 3 == 0) {
                            return "Fizz";
                        } else if (i % 5 == 0) {
                            return "Buzz";
                        } else {
                            return i+"";
                        }
                    })
                    .collect(Collectors.toList());
            return result;
        }
    }

}
