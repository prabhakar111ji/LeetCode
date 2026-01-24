/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        int a = 0, b = 0;
        while(h1!=null){
            h1 = h1.next;a++;
        }
        while(h2!=null){
            h2= h2.next;b++;
        }
        ListNode x = headA, y = headB;
        if(a>b){
            int i = a-b;
            while(i-->0)x = x.next;
        }
        else{
            int i = b-a;
            while(i-->0)y = y.next;
        }
        while(x!=null && y!=null){
            if(x==y)return x;
            else x = x.next;y = y.next;
        }
        return null;
    }
}