package published.p88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (true) {
            if (j < 0) break;
            if (i < 0 || nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
                continue;
            }
            nums1[k--] = nums1[i--];
        }
    }
}

//import java.util.Arrays;
//
//class Solution {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        for (int i = m; i < m + n; i++) {
//            nums1[i] = nums2[i-m];
//        }
//        Arrays.sort(nums1);
//    }
//}
