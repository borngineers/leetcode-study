/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle2(ListNode head) {
        
        if(head == null || head.next == null) {
            return false;
        }
        
        
        // 최대 n - 1 번까지 반복해서 돈다.
        // 1, 2, 3, 4, 5, ..., n-1
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
    
    public boolean hasCycle(ListNode head) {
        
        final Map<ListNode, Object> store = new HashMap<>();
        
        while(head != null) {
            store.put(head, new Object());
            head = head.next;
            
            if(store.get(head) != null) {
                return true;
            }
        }
        
        return false;
    }
}
