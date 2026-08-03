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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        while(k-->1){
            temp = temp.next;
        }
        ListNode left = temp;
        ListNode right = head;
        while(temp.next!=null){
            right = right.next;
            temp = temp.next;
        }
        int t = left.val;
        left.val = right.val;
        right.val = t;
        // swap(left.val, right.val);
        return head;
    }
}