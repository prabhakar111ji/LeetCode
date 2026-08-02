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
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next ==null)return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while(head!=null && head.next!=null){
            // int temp = head.val;
            // head.val = head.next.val;
            // head.next.val = temp;
            // head = head.next.next;

            ListNode next = head.next;
            prev.next = next;
            head.next = next.next;
            next.next = head;
            prev = head;
            head = head.next;
        }
        // ListNode temp = dummy.next;
        // dummy.next = temp.next;
        // temp.next = temp.next.next;
        // dummy.next.next = temp;
        // int x = dummy.next.val;
        // dummy.next.val = temp.val;
        // temp.val = x;
        return dummy.next;
    }
}