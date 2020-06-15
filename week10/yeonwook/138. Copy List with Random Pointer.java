class Solution {
    public Node copyRandomList(Node head) {
        
        Map<Node, Node> dup = new HashMap<>();
        
        Node saveHead = head;
        Node headNode = head;
        while(head != null) {
            
            Node node = new Node(head.val);
            dup.put(head, node);
            
            head = head.next;
        }
        
        while(headNode != null) {
            
            Node node = dup.get(headNode);
            
            node.next = (headNode.next != null) ? dup.get(headNode.next) : null;
            node.random = (headNode.random != null) ? dup.get(headNode.random) : null;
            
            headNode = headNode.next;
        }
        
        return dup.get(saveHead);
    }
}
