import java.util.HashMap;

public class LeetCode141 {
    /**
     * 141. Linked List Cycle
     * https://leetcode.com/problems/linked-list-cycle/
     *
     * Example 1:
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where tail connects to the second node.
     *
     * Example 2:
     * Input: head = [1,2], pos = 0
     * Output: true
     * Explanation: There is a cycle in the linked list, where tail connects to the first node.
     *
     * Example 3:
     * Input: head = [1], pos = -1
     * Output: false
     * Explanation: There is no cycle in the linked list.
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);

        boolean result = solution.hasCycle(node);
        System.out.println(result); // true
    }

    static class Solution {
        // Runtime: 4 ms, faster than 9.97% of Java online submissions for Linked List Cycle.
        // Memory Usage: 40.3 MB, less than 17.81% of Java online submissions for Linked List Cycle.
        public boolean hasCycle(ListNode head) {
            HashMap<Integer, Boolean> map = new HashMap<>();
            while (head != null) {
                if (map.containsKey(head.hashCode())) {
                    return true;
                } else {
                    map.put(head.hashCode(), true);
                }
                head = head.next;
            }
            return false;
        }

    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
