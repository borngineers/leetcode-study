package week03;

import java.io.*;

/**
 * Created by pasudo123 on 2020-01-14
 * Email: oraedoa@gmail.com
 **/
public class RemoveDuplicates {

    private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static BufferedReader reader = new BufferedReader(inputStreamReader);

    private static OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
    private static BufferedWriter writer = new BufferedWriter(outputStreamWriter);

    public static void main(String[] args) throws IOException {

        writer.flush();
    }

    public static int removeDuplicatesFirstSolve(int[] nums) {

        int existUniqueCount = 0;
        int nowValue = 0;

        final int size = nums.length;
        int newIndex = 0;

        if(size == 0){
            return existUniqueCount;
        }

        int[] newArray = new int[size];

        nowValue = nums[0];
        existUniqueCount += 1;
        newArray[newIndex++] = nowValue;

        for(int i = 1; i < size; i++) {

            if(nowValue == nums[i]) {
                continue;
            }

            nowValue = nums[i];
            existUniqueCount += 1;
            newArray[newIndex++] = nowValue;
        }

        System.arraycopy(newArray, 0, nums, 0, existUniqueCount);

        return existUniqueCount;
    }
    
    // 연욱님 코드 참고 ㅎㅎ;
    public static int removeDuplicatesSecondSolve(int[] nums) {

        int existUniqueCount = 0;
        final int size = nums.length;

        if(size == 0) {
            return existUniqueCount;
        }

        int tempIndex = 0;
        for(int i = 1; i < size; i++) {

            if(nums[tempIndex] != nums[i]){
                nums[++tempIndex] = nums[i];
            }
        }

        return tempIndex;
    }
}
