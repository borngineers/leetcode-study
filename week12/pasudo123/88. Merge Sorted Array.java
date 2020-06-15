package leetcode.week05;

import java.util.Arrays;
import java.util.PriorityQueue;

public class S088 {
    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 6, new int[]{2, 5, 6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        int currentIndex = 0;
        while(currentIndex < m){
            final int value = nums1[currentIndex++];
            pq.add(value);
        }

        currentIndex = 0;
        while(currentIndex < n){
            final int value = nums2[currentIndex++];
            pq.add(value);
        }

        currentIndex = 0;
        int maxSize = Math.max(nums1.length, nums2.length);
        while(currentIndex < maxSize && !pq.isEmpty()){
            nums1[currentIndex++] = pq.poll();
        }

        System.out.println(Arrays.toString(nums1));
    }
}
