package week01;

import java.io.*;
import java.util.Arrays;

/**
 * Created by pasudo123 on 2019-12-28
 * Email: oraedoa@gmail.com
 **/
public class TwoSum {

    private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static BufferedReader reader = new BufferedReader(inputStreamReader);

    private static OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
    private static BufferedWriter writer = new BufferedWriter(outputStreamWriter);

    public static void main(String[]args) throws IOException {

        TwoSum twoSum = new TwoSum();

        // case 1
        writer.write(
                twoSum.getStringOnArray(
                        twoSum.twoSum(new int[]{2, 7, 11, 15}, 9)));
        writer.newLine();

        // case 2
        writer.write(
                twoSum.getStringOnArray(
                        twoSum.twoSum(new int[]{2, 7, 11, 15}, 9)));
        writer.newLine();

        // case 3
        writer.write(
                twoSum.getStringOnArray(
                        twoSum.twoSum(new int[]{2, 7, 11, 15}, 9)));
        writer.newLine();

        /** flush **/
        writer.flush();
    }

    public int[] twoSum(int[]nums, int target) {

        int[]returnArrays = new int[2];

        // n^2
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = (i + 1); j < nums.length; j++) {

                int sum = nums[i] + nums[j];

                if(sum == target) {
                    returnArrays[0] = i;
                    returnArrays[1] = j;
                    i = nums.length;
                    break;
                }
            }
        }

        return returnArrays;
    }

    private String getStringOnArray(int[]array) {
        return Arrays.toString(array);
    }
}
