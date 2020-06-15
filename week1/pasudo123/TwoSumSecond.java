package week01;

import java.io.*;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Created by pasudo123 on 2020-01-05
 * Email: oraedoa@gmail.com
 **/
public class TwoSumSecond {

    private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static BufferedReader reader = new BufferedReader(inputStreamReader);

    private static OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
    private static BufferedWriter writer = new BufferedWriter(outputStreamWriter);

    public static void main(String[]args) throws IOException {

        TwoSumSecond twoSumSecond = new TwoSumSecond();

        writer.write(twoSumSecond.getStringOnArray(
                twoSumSecond.twoSum(new int[]{2, 7, 11, 15}, 9)
        ));

        writer.newLine();

        writer.flush();;
    }

    public int[] twoSum(int[] numbers, int target) {

        Hashtable<Integer, Integer> table = new Hashtable<>();

        for(int i = 0; i < numbers.length; i++) {

            int min = target - numbers[i];

            if(table.containsKey(min)) {
                int index1 = table.get(min);
                int index2 = i;

                return new int[]{index1 + 1, index2 + 1};
            }

            table.put(numbers[i], i);
        }

        return null;
    }

    private String getStringOnArray(int[]array) {
        return Arrays.toString(array);
    }
}
