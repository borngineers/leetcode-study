package leetcode.week09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-129);
        head.next = new ListNode(-129);
        System.out.println(isPalindrome(head));

        List<Integer> newList = Arrays.asList(-129, -129);
        System.out.println(newList.get(0) == (int)newList.get(1));
        System.out.println(newList.get(0) != (int)newList.get(1));
    }

    public static boolean isPalindrome(ListNode head) {
        final List<Integer> list = new ArrayList<>();

        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        final int middle = list.size() / 2;
        final boolean even = list.size() % 2 == 0;

        /** wrapper 클래스이기 때문에 equals 로 비교. `==` 은 주소값으로 비교하기 때문. **/
        if(even) {
            int left = middle - 1;
            int right = middle;
            while(left >= 0 && right < list.size()){
                if(!list.get(left--).equals(list.get(right++))){
                    return false;
                }
            }
        } else {
            int left = middle - 1;
            int right = middle + 1;
            while(left >= 0 && right < list.size()){
                if(!list.get(left--).equals(list.get(right++))){
                    return false;
                }
            }
        }

        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

