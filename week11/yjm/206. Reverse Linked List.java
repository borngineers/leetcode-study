import java.util.ArrayList;

public class LeetCode206 {
    /**
     * 206. Reverse Linked List
     * https://leetcode.com/problems/reverse-linked-list/
     *
     * Example:
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     * */
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        a1.next = new ListNode(2);
        a1.next.next = new ListNode(3);
        a1.next.next.next = new ListNode(4);
        a1.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        ListNode result = solution.reverseList(a1);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    static class Solution {

        // 1 ms	/ 39.1 MB
        public ListNode reverseList(ListNode head) {
            ListNode retNode = null;
            ListNode tempNode = null;
            ArrayList<Integer> list = new ArrayList<>();

            while (head != null) {
                list.add(head.val);
                head = head.next;
            }

            if (list.size() == 0) return retNode;

            int lastIndex = list.size() - 1;
            tempNode = new ListNode(list.get(lastIndex));
            retNode = tempNode;
            for (int i = lastIndex - 1; i >= 0; i--) {
                tempNode.next = new ListNode(list.get(i));
                tempNode = tempNode.next;
            }
            return retNode;
        }
        
        // 0 ms	/ 38.9 MB
        public ListNode reverseList2(ListNode head) {
            if (head == null) { return null; }
            ListNode temp = new ListNode(head.val);
            head = head.next;
            while (head != null) {
                ListNode n = new ListNode(head.val);
                n.next = temp;
                temp = n;
                head = head.next;
            }
            return temp;
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
