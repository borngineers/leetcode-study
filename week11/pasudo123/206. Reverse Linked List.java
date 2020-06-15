package leetcode.week04;

import java.util.ArrayList;
import java.util.List;

public class S206 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {

        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        int lastIndex = list.size() - 1;
        ListNode node = new ListNode(0);
        ListNode newHead = node;
        for(int i = lastIndex; i >= 0; i--){
            node.next = new ListNode(list.get(i));
            node = node.next;
        }

        return newHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
