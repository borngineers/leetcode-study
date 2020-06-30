/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * } 
 */
 /*
 LinkedList -> 544 ms
 ArrayList -> 3ms
 삽입이 많아 처음에 LinkedList를 사용하였으나 속도가 나오지 않아 ArrayList로 바꿔봄
 비교 연산자를 '=='로 사용했다가 오답으로 출력되어
 equals함수로 변경. ==와 equals의 차이점에 대해 한번 얘기해보는것도 좋을듯.
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null) {
            return true;
        }
        
        List<Integer> list  = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            
            head = head.next;
        }
        
        int len = list.size();
        int mid = len >> 1;
        int left = mid - 1;
        int right = mid;
        
        if( len % 2 == 1) {
            left = mid - 1;
            right = mid + 1;
        } else{
            left = mid - 1;
            right = mid;
        }
        
        while(left >=0 && right < len) {
            
            if(!list.get(left).equals(list.get(right))) {
                return false;
            }
            
            left--;
            right++;
        }
        
        return true;
    }
}
