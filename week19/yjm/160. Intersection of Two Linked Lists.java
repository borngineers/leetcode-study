import java.util.HashSet;
import java.util.Set;

public class LeetCode160 {
    /**
     * 160. Intersection of Two Linked Lists
     * https://leetcode.com/problems/
     * <p>
     * Example 1:
     * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
     * Output: Reference of the node with value = 8
     * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
     * <p>
     * Example 2:
     * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * Output: Reference of the node with value = 2
     * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
     * <p>
     * Example 3:
     * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * Output: null
     * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
     * Explanation: The two lists do not intersect, so return null.
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode inter = new ListNode(8);

        ListNode s1 = new ListNode(4);
        s1.next = new ListNode(1);
        s1.next.next = inter;

        ListNode s2 = new ListNode(5);
        s2.next = new ListNode(6);
        s2.next.next = new ListNode(1);
        s2.next.next = inter;

        inter.next = new ListNode(4);
        inter.next.next = new ListNode(5);

        ListNode result = solution.getIntersectionNode(s1, s2);

        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }

        System.out.println("");
    }

    static class Solution {
        // Runtime: 7 ms, faster than 28.88% of Java online submissions for Intersection of Two Linked Lists.
        // Memory Usage: 43.3 MB, less than 5.90% of Java online submissions for Intersection of Two Linked Lists.
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> nodeSet = new HashSet<>();
            ListNode tempA = headA;
            ListNode tempB = headB;

            while (tempA != null) {
                nodeSet.add(tempA);
                tempA = tempA.next;
            }

            while (tempB != null) {
                if (nodeSet.contains(tempB)) {
                    return tempB;
                }
                tempB = tempB.next;
            }

            return null;
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
