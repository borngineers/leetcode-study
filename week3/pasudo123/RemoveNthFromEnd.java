package week03;

public class RemoveNthFromEnd {

    public static void main(String[]args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode header = removeNthFromEnd(node, 5);

        while(header != null) {
            System.out.println(header.val);
            header = header.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int fullNodeCount = 0;

        ListNode node = head;

        while(node != null) {
            node = node.next;
            fullNodeCount++;
        }


        node = head;
        int count = 1;
        int splitNthCount = fullNodeCount - n;

        if(splitNthCount == 0){
            head = head.next;
            return head;
        }

        while(count != splitNthCount) {
            node = node.next;
            count++;
        }

        node.next = node.next.next;

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
