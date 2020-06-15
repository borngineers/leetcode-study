import java.util.*;

public class LeetCode21 {
    /**
     * 21. Merge Two Sorted Lists
     * https://leetcode.com/problems/merge-two-sorted-lists/
     *
     * Example:
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     * */

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        a1.next = new ListNode(2);
        a1.next.next = new ListNode(4);
        ListNode a2 = new ListNode(1);
        a2.next = new ListNode(3);
        a2.next.next = new ListNode(4);

        Solution solution = new Solution();
        System.out.println(solution.mergeTwoLists(a1, a2));
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode node1 = l1;
            ListNode node2 = l2;
            ArrayList<Integer> numList = new ArrayList<>();

            while (node1 != null) {
                numList.add(node1.val);
                node1 = node1.next;
            }
            while (node2 != null) {
                numList.add(node2.val);
                node2 = node2.next;
            }
            if (numList.size() < 1) {
                return null;
            }

            Collections.sort(numList);

            ListNode retNode = new ListNode(numList.get(0));
            ListNode tempNode = retNode;
            for (int i = 1; i < numList.size(); i++) {
                tempNode.next = new ListNode(numList.get(i));
                tempNode = tempNode.next;
            }

            return retNode;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
