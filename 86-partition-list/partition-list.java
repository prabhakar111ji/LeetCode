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
    private ListNode pnfgn(ListNode dummy, int x){
        ListNode prev = dummy;
        while(prev.next!=null && prev.next.val<x){
            prev = prev.next;
        }
        return prev;
    }
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pnfgn = pnfgn(dummy, x);
        ListNode fgn = pnfgn.next;
        if(pnfgn.next == null)return head;
        if(fgn.next == null)return head;
        ListNode curr = fgn.next;
        ListNode prev = fgn;
        while(curr!=null){
            if(curr.val<x){
                pnfgn.next = curr;
                prev.next = curr.next;
                curr.next = fgn;
                pnfgn = curr;
                curr = prev.next;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}