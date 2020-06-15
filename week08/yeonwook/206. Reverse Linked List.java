/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode answer = null;
        
        while(head != null) {
            
            ListNode temp = new ListNode(head.val);
            temp.next = answer;
            answer = temp;
            
            head = head.next;
        }
        
        return answer;
    }
}
