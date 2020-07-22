package p141;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    private final Map<ListNode, Object> map = new HashMap<>();

    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            }
            map.put(temp, new Object());
            temp = temp.next;
        }
        return false;
    }
}