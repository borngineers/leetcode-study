class Solution {
    public List<Integer> minSubsequence(int[] nums) {
    Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int size = nums.length;
        int subSum = 0;
        System.out.println(sum);
        List<Integer> retList = new ArrayList<>();

        for (int i = size - 1; i >= 0; i--) {
            subSum += nums[i];
            retList.add(nums[i]);
            if (subSum > (sum - subSum)) {
                break;
            }
        }
        return retList;
    }
}
