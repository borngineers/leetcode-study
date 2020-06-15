package leetcode.week07;

public class S033 {
    public static void main(String[] args) {
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 4));
        System.out.println(search(new int[]{6,7,0,1,2,4,5}, 0));
    }

    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        // 중간 pivot 찾기.
        while(left < right) {
            int middle = left + ((right - left) / 2);

            if(nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        int start = left;
        left = 0;
        right = nums.length - 1;

        if(target >= nums[start] && target <= nums[right]){
            left = start;
        } else {
            right = start;
        }

        while(left <= right) {
            int middle = left + (right - left) / 2;
            if(nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
