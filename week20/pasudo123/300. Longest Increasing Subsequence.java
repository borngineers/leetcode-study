class Solution {
    public static int lengthOfLIS(final int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        final int[] newNums = new int[nums.length];
        Arrays.fill(newNums, Integer.MAX_VALUE);
        int currentIndex = 0;
        newNums[currentIndex] = nums[currentIndex];

        for(int index = 1; index < nums.length; index++) {
            if(newNums[currentIndex] < nums[index]) {
                newNums[++currentIndex] = nums[index];
                continue;
            }

            if(newNums[currentIndex] > nums[index]) {
                // 작은 값을 만날 시 바이너리 서치로 해당 위치 인덱스를 찾고 값을 변경한다.
                final int findIndex = lowerBound(newNums, 0, newNums.length - 1, nums[index]);
                newNums[findIndex] = nums[index];
            }
        }

        return currentIndex + 1;
    }

    private static int lowerBound(int arr[], int front, int rear, int key){
        int mid;
        while(front<rear){
            mid = (front + rear) / 2;
            if(arr[mid] < key) front = mid + 1;
            else rear = mid;
        }
        return rear;
    }
}
