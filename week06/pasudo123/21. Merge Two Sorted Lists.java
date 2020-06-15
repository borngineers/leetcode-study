package leetcode.week03;

public class S021 {

    public static void main(String[]args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);

        mergeTwoLists(l1, l2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) {
            return null;
        }

        ListNode node = new ListNode(0);
        ListNode head = node;

        while(l1 != null && l2 != null){

            if(l1.val < l2.val){
                node.val = l1.val;
                l1 = l1.next;
            } else {
                node.val = l2.val;
                l2 = l2.next;
            }

            node.next = new ListNode(0);
            node = node.next;
        }

        while(l1 != null){
            node.val = l1.val;
            l1 = l1.next;
            if(l1 != null){
                node.next = new ListNode(0);
                node = node.next;
            }
        }

        while(l2 != null){
            node.val = l2.val;
            l2 = l2.next;
            if(l2 != null) {
                node.next = new ListNode(0);
                node = node.next;
            }
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


