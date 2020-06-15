# [Leetcode] 138. Copy List with Random Pointer

`Random Pointer`를 가지고 있는 특수한 `Linked List`를 깊은 복사(`Deep Copy`)를 하여 반환한다.

## Solution

리스트를 복사하기 전에 `HashMap`을 선언한다. 이 `HashMap`은 `Random Pointer`를 효과적으로 제어하기 위해 사용되며, 원래 리스트의 노드들이 키가 되고 새로운 리스트의 노드들이 값으로 맵핑된다.

원래 링크드 리스트를 순차적으로 탐색하면서 노드들을 복사한다. 이때, `Random Pointer`를 연결하면서 노드가 이미 생성되어있을 수 있으므로 `HashMap`을 탐색하여 노드가 있는지 확인한다. 없다면 새로 생성하여 `HashMap`에 갱신한다.

새로운 노드가 새로운 리스트에 연결되면 `Random Ponter`가 가리키는 노드를 연결해야 한다. 이 역시 노드가 이미 생성되어있을 수 있으므로 `HashMap`을 탐색하여 노드가 있는지 확인한다. 없다면 새로 생성하여 `HashMap`에 갱신한다.

```java
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
```

| Time Complexity | Runtime | Memory |
|-----------------|---------|--------|
| O(N) | 0 ms | 39 MB |
