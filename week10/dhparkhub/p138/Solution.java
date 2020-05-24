package p138;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    private final Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        Node headNode = null;
        Node curNode = null;
        Node tempNode;
        while (head != null) {
            tempNode = map.getOrDefault(head, new Node(head.val));
            if (headNode == null) {
                headNode = curNode = tempNode;
            } else {
                curNode = curNode.next = tempNode;
            }
            map.put(head, tempNode);

            if (head.random != null) {
                tempNode = map.getOrDefault(head.random, new Node(head.random.val));
                curNode.random = tempNode;
                map.put(head.random, tempNode);
            }

            head = head.next;
        }
        return headNode;
    }
}