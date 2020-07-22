public class Solution {
    public boolean hasCycle(ListNode head) {
        
        Set<ListNode> check = new HashSet<>();
        
        while(head != null) {
            if(check.contains(head)) return true;
            
            check.add(head);
            head = head.next;
        }
        
        return false;
    }
}
