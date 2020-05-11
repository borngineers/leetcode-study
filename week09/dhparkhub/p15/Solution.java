package solved.p15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);// O(N * logN)

        List<List<Integer>> answer = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;// skip same case

            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j - 1 >= i + 1 && nums[j] == nums[j - 1]) continue;// skip same case

                int twoSum = nums[i] + nums[j];
                int tempIndex = Arrays.binarySearch(nums, j + 1, nums.length, -twoSum);
                if (tempIndex < 0) continue;
                answer.add(Arrays.asList(nums[i], nums[j], -twoSum));// O(logN)
            }
        }// O(N^2 * logN)

        return answer;
    }
}