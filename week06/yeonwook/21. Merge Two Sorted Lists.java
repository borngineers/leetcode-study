/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode answer = null;
        ListNode head = new ListNode(0);
        answer = head;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while(l1 != null && l2 != null) {
            
            if(l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            
            head = head.next;
        }
        
        if(l1 != null) {
            head.next = l1;
        }
        
        if(l2 != null) {
            head.next = l2;
        }
        
        return answer.next;
        
    }
}