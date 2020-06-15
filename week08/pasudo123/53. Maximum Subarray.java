package leetcode.week04;

public class S053 {

    public static void main(String[]args) {

    }

    public int maxSubArray(int[] nums) {

        /** 현재 인덱스 값과 내가 현재까지 들고온 값을 비교 **/

        final int size = nums.length;

        int maxValue = Integer.MIN_VALUE;
        int iCarrayingSum = 0;

        for(int i = 0; i < size; i++) {
            iCarrayingSum = Math.max(nums[i] + iCarrayingSum, nums[i]);
            maxValue = Math.max(maxValue, iCarrayingSum);
        }

        return maxValue;
    }
}
