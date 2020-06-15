package week04;

public class MaxSubArray {

    public static void main(String[]args) {

        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        System.out.println(maxSubArray(new int[]{-2}));

    }

    public static int maxSubArray(int[] nums) {

        /** 현재 인덱스 값과 내가 현재까지 들고온 값을 비교 **/

        final int size = nums.length;

        int maxValue = Integer.MIN_VALUE;
        int iCarrayingSum = 0;

        for(int i = 0; i < size; i++) {

            iCarrayingSum = (nums[i] + iCarrayingSum > nums[i])
                    ? nums[i] + iCarrayingSum
                    : nums[i];

            maxValue = (maxValue > iCarrayingSum)
                    ? maxValue
                    : iCarrayingSum;
        }

        return maxValue;
    }
}
