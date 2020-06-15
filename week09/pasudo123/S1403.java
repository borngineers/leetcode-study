package leetcode.week02;

import java.util.*;

public class S1403 {

    public static List<Integer> minSubsequence(int[] nums) {

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        Arrays.sort(nums);
        List<Integer> retArray = new ArrayList<>();

        int currentSum = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            currentSum += nums[i];
            sum -= nums[i];
            retArray.add(nums[i]);
            if(sum < currentSum) {
                break;
            }
        }

        retArray.sort(Comparator.reverseOrder());

        return retArray;
    }
}
