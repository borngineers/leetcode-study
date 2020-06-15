/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode answer = new ListNode(0);
        ListNode head = answer;
        
        int carry = 0;
        
        while(l1 != null || l2 != null) {
            
            
            ListNode tempNode = new ListNode(0);
            
            int a = (l1 == null) ? 0 : l1.val;
            int b = (l2 == null) ? 0 : l2.val;
            
            if(a + b + carry >= 10) {
                tempNode.val = (a + b + carry) % 10;
                carry = 1;
            } else {
                tempNode.val = a + b + carry;
                carry = 0;
            }
            
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            head.next = tempNode;
            head = head.next;
            
        }
        
        if(carry > 0) {
            ListNode tempNode = new ListNode(1);
            head.next = tempNode;
        }
        
        return answer.next;
        
    }
}