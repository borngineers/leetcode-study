package published;

public class P2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode headNode = null;
            ListNode curNode = null;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int l1Val = l1 == null ? 0 : l1.val;
                int l2Val = l2 == null ? 0 : l2.val;

                int tempNum = (l1Val + l2Val + carry) % 10;
                carry = (l1Val + l2Val + carry) / 10;

                ListNode tempNode = new ListNode(tempNum);
                if (headNode == null) {
                    headNode = curNode = tempNode;
                } else {
                    curNode.next = tempNode;
                    curNode = tempNode;
                }

                l1 = l1 == null ? l1 : l1.next;
                l2 = l2 == null ? l2 : l2.next;
            }

            if (carry == 1) {
                curNode.next = new ListNode(1);
            }

            return headNode;
        }
    }

}
