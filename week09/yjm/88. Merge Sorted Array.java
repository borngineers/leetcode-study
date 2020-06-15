import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetCode88 {
    /**
     * 88. Merge Sorted Array
     * https://leetcode.com/problems/merge-sorted-array/
     *
     * Example:
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * Output: [1,2,2,3,5,6]
     * */

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] mList = new int[]{1,2,3,0,0,0};
//        int[] nList = new int[]{2,5,6};
//        solution.merge(mList, 3, nList, 3);
//        for (int x : mList) {
//            System.out.print(x + ", ");
//        }

        int[] mList = new int[]{2,4,0,0,0,0};
        int[] nList = new int[]{1,3};
        solution.merge(mList, 2, nList, 2);
        for (int x : mList) {
            System.out.print(x + ", ");
        }
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            List<Integer> list1 = IntStream.range(0, m)
                    .map(i -> nums1[i])
                    .boxed()
                    .collect(Collectors.toList());

            List<Integer> list2 = IntStream.range(0, n)
                    .map(i -> nums2[i])
                    .boxed()
                    .collect(Collectors.toList());

            list1.addAll(list2);
            Collections.sort(list1);

            for (int i = 0; i < nums1.length; i++) {
                if (i < m+n) {
                    nums1[i] = list1.get(i);
                } else {
                    nums1[i] = 0;
                }
            }
        }
    }

}
