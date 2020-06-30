package p234;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    private final List<Integer> list = new ArrayList<>();

    public boolean isPalindrome(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }// O(N)

        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - i - 1))) {
                return false;
            }
        }// O(N)

        return true;
    }
}