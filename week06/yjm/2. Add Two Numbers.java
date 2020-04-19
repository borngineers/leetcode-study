public class LeetCode2 {
    /**
     * 2. Add Two Numbers
     * https://leetcode.com/problems/add-two-numbers/
     *
     * Example:
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     * */

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        a1.next = new ListNode(4);
        a1.next.next = new ListNode(3);
        ListNode a2 = new ListNode(5);
        a2.next = new ListNode(6);
        a2.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(a1, a2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode node1 = l1;
            ListNode node2 = l2;

            ListNode retNode = null;
            ListNode tempNode = null;

            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();
            boolean carry = false;

            while (node1 != null) {
                str1.append(node1.val);
                node1 = node1.next;
            }
            while (node2 != null) {
                str2.append(node2.val);
                node2 = node2.next;
            }

            int large = str1.length();
            if (str1.length() < str2.length()) large = str2.length();

            int temp = 0;
            for (int i = 0; i < large; i++) {
                if (i >= str1.length()) {
                    temp = str2.charAt(i) - '0';
                }else if (i >= str2.length()) {
                    temp = str1.charAt(i) - '0';
                } else {
                    temp = (str1.charAt(i) - '0') + (str2.charAt(i) - '0');
                }
                if (carry) temp += 1;
                carry = false;
                if (temp >= 10) {
                    carry = true;
                    temp -= 10;
                }
                if (i == 0) {
                    retNode = new ListNode(temp);
                    tempNode = retNode;
                } else {
                    tempNode.next = new ListNode(temp);
                    tempNode = tempNode.next;
                }
            }
            if (carry) tempNode.next = new ListNode(1);

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
