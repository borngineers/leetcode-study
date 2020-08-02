public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode answer=null;
        Set<ListNode> check = new HashSet<>();
        
        while(headA != null) {
            
            check.add(headA);
            headA = headA.next;
        }
        
        while(headB != null) {
            
            if(check.contains(headB)) {
                answer = headB;
                break;
            }
            headB = headB.next;
        }
        
        return answer;
    }
}
