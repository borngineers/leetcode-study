import practice.ListNode;

public class Solution2 {
	
	/*
	 * 
	 * Given a linked list, remove the n-th node from the end of list and return its head.
		Example:
		Given linked list: 1->2->3->4->5, and n = 2.
		After removing the second node from the end, the linked list becomes 1->2->3->5.
	 * 
	 */
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
    	if(head==null) {
    		return null;
    	}
     	
        int len = 1;
        
        ListNode currentNode = head;
        while(currentNode.next != null) {
        	currentNode = currentNode.next;
        	len++;
        }
        
        if(n>len) {
        	return head;
        }
        
        
    	if(n==len) {
    		return head.next;
    	}
    	
    	int i = 1;
    	ListNode tempNode = head;
        while(i<=(len-n)) {
        	
        	if(i==(len-n)) {
        		
        		tempNode.next = tempNode.next.next; 
        		break;
        	}
        	tempNode = tempNode.next;
        	i++;
        }
    	
    	return head;
    }
}