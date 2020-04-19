package solved;

public class P206 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode prevNode = null;
            ListNode curNode = head;
            ListNode nextNode = head.next;
            while (curNode != null) {
                curNode.next = prevNode;
                prevNode = curNode;
                curNode = nextNode;
                if (curNode != null) {
                    nextNode = curNode.next;
                }
            }
            return prevNode;
        }
    }

}
