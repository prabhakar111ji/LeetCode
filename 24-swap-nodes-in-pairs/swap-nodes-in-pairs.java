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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while(head!=null && head.next!=null){

            ListNode sec = head.next;
            prev.next = sec;
            // head.next.next = 
            head.next = sec.next;
            sec.next = head;
            prev = head;
            head = head.next;
        }
        // if(head == null || head.next == null)return head;
        // ListNode p = head.next;
        // while(head!=null && head.next !=null){
        //     ListNode temp = head.next;
        //     head.next = head.next.next;
        //     temp.next = head;
        //     // head = temp;
        //     // head = head.next.next;
        //     head = head.next;
        // }
        // return p;
        return dummy.next;
    }
}