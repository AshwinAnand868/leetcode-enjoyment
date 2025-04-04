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
    public ListNode mergeNodes(ListNode head) {

        ListNode p1 = head.next;
        ListNode p2 = p1;

        while(p2 != null) {
            int sum = 0;

            while(p2 != null && p2.val != 0) {
                sum += p2.val;
                p2 = p2.next;
            }

            p1.val = sum;
            p2 = p2.next;
            p1.next = p2;
            p1 = p1.next;
        }

        return head.next;

        // if(head == null) return head;

        // ListNode dummy = new ListNode(0);
        // ListNode newNode = dummy;

        // ListNode curr = head.next;
        // int val = 0;

        // while(curr.next != null) {
        //     val += curr.val;
        //     if(curr.val == 0) {
        //         newNode.next = new ListNode(val);
        //         newNode = newNode.next;
        //         val = 0;
        //     }
        //     curr = curr.next;
        // }

        // newNode.next = new ListNode(val);

        // return dummy.next;
    }
}