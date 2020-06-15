package leetcode.week03;

public class S002 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);

        addTwoNumbers(l1, l2);
    }

    static boolean roundUp = false;

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;

        int sum = 0;
        while(l1 != null || l2 != null){

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            node.next = new ListNode(sum % 10);
            node = node.next;
            sum = sum / 10;
        }

        if(sum >= 1){
           node.next = new ListNode(1);
        }

        return head.next;
    }

    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
