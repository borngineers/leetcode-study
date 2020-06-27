/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Runtime: 6 ms, faster than 9.84% of Java online submissions for Palindrome Linked List.
    // Memory Usage: 46.8 MB, less than 5.02% of Java online submissions for Palindrome Linked List.
    public boolean isPalindrome(ListNode head) {
        if (head == null) { return true; }
        boolean result = true;

        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        head = head.next;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int listSize = list.size();
        for (int i = 0; i < listSize / 2; i++) {
            if (!list.get(i).equals(list.get(listSize - 1 - i))) {
                result = false;
                break;
            }
        }

        return result;
    }
}
