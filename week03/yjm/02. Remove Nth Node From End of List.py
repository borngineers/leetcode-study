# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        node_stack = []
        temp_node = head
        
        while temp_node.next != None :
            node_stack.append(temp_node)
            temp_node = temp_node.next
                    
        node_stack.append(temp_node)
        
        if len(node_stack) == n :
            return head.next
                
        for x in range(n) :
            remove_node = node_stack.pop()
            
        if n > 0 and len(node_stack) > 0 :
            pre_node = node_stack.pop()
            pre_node.next = remove_node.next
        
        return head
