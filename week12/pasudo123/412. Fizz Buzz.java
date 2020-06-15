package leetcode.week05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class S412 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fizzBuzz(15).toArray()));
    }

    public static List<String> fizzBuzz(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(i -> {
                    if (isFizz(i) && isBuzz(i)) {
                        return "FizzBuzz";
                    } else if (isFizz(i)) {
                        return "Fizz";
                    } else if (isBuzz(i)) {
                        return "Buzz";
                    } else {
                        return String.valueOf(i);
                    }
                }).collect(Collectors.toList());
    }

    private static boolean isFizz(int number) {
        return (number % 3 == 0);
    }

    private static boolean isBuzz(int number) {
        return (number % 5 == 0);
    }
}
