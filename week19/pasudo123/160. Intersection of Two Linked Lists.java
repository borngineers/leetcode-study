/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * 데이터가 중복으로 연속적으로 나온경우
     **/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final Map<ListNode, Object> store = new HashMap<>();
        
        ListNode preNode = headA;
        while(preNode != null) {
            store.put(preNode, new Object());
            preNode = preNode.next;
        }
        
        ListNode postNode = headB;
        while(postNode != null) {
            if(store.containsKey(postNode)){
                return postNode;
            }
            
            postNode = postNode.next;
        }
        
        return null;
    }
}
